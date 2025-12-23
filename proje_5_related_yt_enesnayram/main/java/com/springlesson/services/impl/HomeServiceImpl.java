package com.springlesson.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springlesson.dto.DtoHome;
import com.springlesson.dto.DtoHomeIU;
import com.springlesson.dto.DtoRoom;
import com.springlesson.dto.DtoRoomIU;
import com.springlesson.entites.Home;
import com.springlesson.entites.Room;
import com.springlesson.repository.IHomeRepository;
import com.springlesson.services.IHomeServices;

@Service
public class HomeServiceImpl implements IHomeServices {
	@Autowired
	private IHomeRepository homeRepository;

	@Override
	public DtoHome getHomeById(Long homeId) {
		// TODO Auto-generated method stub
		Optional<Home> optional = homeRepository.findById(homeId);
		
		if(optional.isPresent()) {
			Home home = optional.get();
			DtoHome dtoHome = new DtoHome();
			BeanUtils.copyProperties(home, dtoHome);
			
			if(home.getRoom() != null && !home.getRoom().isEmpty()) {
				for(Room room : home.getRoom()) {
					DtoRoom dtoRoom = new DtoRoom();
					BeanUtils.copyProperties(room, dtoRoom);
					
					dtoHome.getRooms().add(dtoRoom);
				}
			}
			
			return dtoHome;
		}
		
		return null;
	}

	@Override
	public List<DtoHome> getAllHome() {
		// TODO Auto-generated method stub
		List<Home> homeList = homeRepository.findAll();
		List<DtoHome> dtoHomeList = new ArrayList<>();
		
		for(Home home : homeList) {
			DtoHome dtoHome = new DtoHome();
			BeanUtils.copyProperties(home, dtoHome);
			
			List<Room> roomList = home.getRoom();
			if(roomList != null && !roomList.isEmpty()) {
				for(Room room : roomList) {
					DtoRoom dtoRoom = new DtoRoom();
					BeanUtils.copyProperties(room, dtoRoom);
					dtoHome.getRooms().add(dtoRoom);
				}
			}
			dtoHomeList.add(dtoHome);
		}
		
		return dtoHomeList;
	}

	@Override
	public DtoHome saveHome(DtoHomeIU dtoHomeIU) {
		// TODO Auto-generated method stub
		Home home = new Home();
		BeanUtils.copyProperties(dtoHomeIU, home);
		
		List<DtoRoomIU> dtoRoomIUList = dtoHomeIU.getRooms();
		if(dtoRoomIUList != null && !dtoRoomIUList.isEmpty()) {
			for(DtoRoomIU dtoRoomIU : dtoRoomIUList) {
				Room room = new Room();
				BeanUtils.copyProperties(dtoRoomIU, room);
				home.getRoom().add(room);
			}
		}
		
		return getHomeById(homeRepository.save(home).getId());
	}

	@Override
	public DtoHome updateHome(Long homeId, DtoHomeIU dtoHomeIU) {
		// TODO Auto-generated method stub
		Optional<Home> optional = homeRepository.findById(homeId);
		if(optional.isPresent()) {
			Home home = optional.get();
			home.setLocation(dtoHomeIU.getLocation());
			home.setPrice(dtoHomeIU.getPrice());
			home.getRoom().clear();
			
			List<DtoRoomIU> dtoRoomIUsList = dtoHomeIU.getRooms();
			if(dtoRoomIUsList != null && !dtoRoomIUsList.isEmpty()) {
				for(DtoRoomIU dtoRoomIU : dtoRoomIUsList) {
					Room room = new Room();
					BeanUtils.copyProperties(dtoRoomIU, room);
					home.getRoom().add(room);
				}
			}
			
			return getHomeById(homeRepository.save(home).getId());
		}
		return null;
	}

	@Override
	public void deleteHome(Long homeId) {
		// TODO Auto-generated method stub
		Optional<Home> optinal = homeRepository.findById(homeId);
		if(optinal.isPresent()) {
			Home home = optinal.get();
			homeRepository.delete(home);
		}
	}
}
