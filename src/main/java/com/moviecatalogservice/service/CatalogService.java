package com.moviecatalogservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moviecatalogservice.model.CatalogItem;
import com.moviecatalogservice.repository.CatalogRepository;

@Service
public class CatalogService {
	
	@Autowired
	private CatalogRepository catalogRepository;
	
	
	
	public List<CatalogItem> getAllCatalogItem()
	{
		List<CatalogItem> allCatalog=new ArrayList<>();
		catalogRepository.findAll().forEach(allCatalog::add);
		return allCatalog;	
	}
	
	public CatalogItem  addCatalogItem(CatalogItem catalogItem)
	{
		CatalogItem save = catalogRepository.save(catalogItem);
		return save;
	}
 
}
