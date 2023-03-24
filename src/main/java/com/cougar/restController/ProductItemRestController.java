package com.cougar.restController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cougar.entity.ProductConfiguration;
import com.cougar.entity.ProductItem;
import com.cougar.model.ProductItemColorSize;
import com.cougar.service.ProductConfigurationService;
import com.cougar.service.ProductItemService;

@CrossOrigin("*")
@RestController
public class ProductItemRestController {
	@Autowired
	ProductItemService productItemService;

	@Autowired
	ProductConfigurationService productConfigurationService;

//	@GetMapping("/rest/productItems")
//	public List<ProductItem> getAll() {
//		return productItemService.findAll();
//	}

	@GetMapping("/rest/productItems/{id}")
	public ProductItem getOne(@PathVariable("id") Integer id) {
		return productItemService.findById(id);
	}

	@PostMapping("/api/productItems")
	public ProductItem create(@RequestBody ProductItem prI) {
		return productItemService.save(prI);
	}

	@PutMapping("/rest/productItems/{id}")
	public ProductItem update(@PathVariable("id") Integer id, @RequestBody ProductItem prI) {
		return productItemService.update(prI);
	}

	@DeleteMapping("/rest/productItems/{id}")
	public void delete(@PathVariable("id") Integer id) {
		productItemService.delete(id);
	}

	@GetMapping("/rest/productItems")
	public List<ProductItemColorSize> getAll() {
		List<ProductItemColorSize> listPr = new ArrayList<>();

		List<ProductItem> list = productItemService.findAll();

		for (ProductItem pr : list) {
			List<ProductConfiguration> con = productConfigurationService.findByProductItemId(pr.getId());
			String size = "";
			String color = "";
			for (int i = 0; i < con.size(); i++) {

				if (con.get(i).getOption().getVariation().getName().equalsIgnoreCase("size")) {
					size = con.get(i).getOption().getValue();

				}
				if (con.get(i).getOption().getVariation().getName().equalsIgnoreCase("color")) {
					color = con.get(i).getOption().getValue();
				}
				for (int j = 0; j < con.size(); j++) {

					if (con.get(j).getOption().getVariation().getName().equalsIgnoreCase("size")) {
						size = con.get(j).getOption().getValue();

					}

					if (con.get(j).getOption().getVariation().getName().equalsIgnoreCase("color")) {
						color = con.get(j).getOption().getValue();
					}
				}

			}
			ProductItemColorSize prd = new ProductItemColorSize(pr, color, size);
			listPr.add(prd);

		}

		return listPr;
	}

}
