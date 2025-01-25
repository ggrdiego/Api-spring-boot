package com.ggrdiego.api_spring_boot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.ggrdiego.api_spring_boot.entities.User;
import com.ggrdiego.api_spring_boot.repositories.UserRepository;
import com.ggrdiego.api_spring_boot.services.exceptions.DatabaseException;
import com.ggrdiego.api_spring_boot.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {

		return repository.findAll();
	}

	public User findById(Long id) {

		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}

	public User insert(User user) {
		return repository.save(user);

	}

	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	public User update(long id, User obj) {
		try {User entityMonitored = repository.getReferenceById(id);
		updateData(entityMonitored, obj);
		return repository.save(entityMonitored);
			
		} catch (EntityNotFoundException e ) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(User entityMonitored, User obj) {
		entityMonitored.setName(obj.getName());
		entityMonitored.setEmail(obj.getEmail());
		entityMonitored.setPhone(obj.getPhone());

	}

}
