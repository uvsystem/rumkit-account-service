package com.dbsys.rs.account.controller;

import java.util.List;

import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dbsys.rs.account.service.UnitService;
import com.dbsys.rs.ApplicationException;
import com.dbsys.rs.EntityRestMessage;
import com.dbsys.rs.ListEntityRestMessage;
import com.dbsys.rs.RestMessage;
import com.dbsys.rs.account.entity.Unit;

@Controller
@RequestMapping("/unit")
public class UnitController {

	@Autowired
	private UnitService unitService;
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public EntityRestMessage<Unit> save(@RequestBody Unit unit) throws ApplicationException, PersistenceException {
		unit = unitService.save(unit);
		return new EntityRestMessage<Unit>(unit);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@ResponseBody
	public EntityRestMessage<Unit> get(@PathVariable Long id) throws ApplicationException, PersistenceException {
		Unit unit = unitService.get(id);
		return new EntityRestMessage<Unit>(unit);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	@ResponseBody
	public RestMessage delete(@PathVariable Long id) throws ApplicationException, PersistenceException {
		unitService.delete(id);
		return RestMessage.success();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public ListEntityRestMessage<Unit> getAll() throws ApplicationException, PersistenceException {
		List<Unit> list = unitService.getAll();
		return new ListEntityRestMessage<Unit>(list);
	}
}
