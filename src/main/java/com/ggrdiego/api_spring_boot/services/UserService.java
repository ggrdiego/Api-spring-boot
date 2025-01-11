package com.ggrdiego.api_spring_boot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ggrdiego.api_spring_boot.entities.User;
import com.ggrdiego.api_spring_boot.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;

	public List<User> findAll() {

		return repository.findAll();
	}

	public User findById(Long id) {

		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

	public User insert(User user) {
		return repository.save(user);

	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public User update(long id, User obj) {
		User entityMonitored = repository.getReferenceById(id);
		updateData(entityMonitored, obj);
		return repository.save(entityMonitored);

	}

	private void updateData(User entityMonitored, User obj) {
		entityMonitored.setName(obj.getName());
		entityMonitored.setEmail(obj.getEmail());
		entityMonitored.setPhone(obj.getPhone());

	}

}
