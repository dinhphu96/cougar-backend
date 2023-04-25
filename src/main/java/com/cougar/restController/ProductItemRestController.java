package com.cougar.restController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.cougar.entity.ProductConfiguration;
import com.cougar.entity.ProductItem;
import com.cougar.model.ProductItemColorSize;
import com.cougar.service.ProductConfigurationService;
import com.cougar.service.ProductItemService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/productItems")
public class ProductItemRestController {
	@Autowired
	ProductItemService productItemService;

	@Autowired
	ProductConfigurationService productConfigurationService;

//	@GetMapping("/rest/productItems")
//	public List<ProductItem> getAll() {
//		return productItemService.findAll();
//	}

	@GetMapping("/{id}")
	public ProductItem getOne(@PathVariable("id") Integer id) {
		return productItemService.findById(id);
	}

	@PostMapping("")
	public ProductItem createFromAdmin(@RequestBody ProductItem prI) {
		if (prI.getId() == null) {

			String urlImage = prI.getImage();

			prI.setImage("change");
			ProductItem prdItem = productItemService.save(prI);

			Map<String, String> config = new HashMap<>();

			config.put("cloud_name", "dmjh7imwd");
			config.put("api_key", "778777726581776");
			config.put("api_secret", "maiZWuW_V9AF9gIfGJ7ZLHpb3z8");

			Cloudinary cloud = new Cloudinary(config);

			String nameImage = "product_item-image-id-" + prdItem.getId();
			@SuppressWarnings("rawtypes")
			Map params = ObjectUtils.asMap("public_id", nameImage, // Nếu trùng tên cũ sẽ ghi đè
					"overwrite", true, "upload_preset", "cougarstrore");

			try {
				Object res = cloud.uploader().upload(urlImage, params);
				// URL để lưu vào database
				@SuppressWarnings("unchecked")
				String urlUploaded = ((Map<String, String>) res).get("url")
						.replace("http://res.cloudinary.com/dmjh7imwd/image/upload/", "");

				prdItem.setImage(urlUploaded);
				return productItemService.update(prdItem);
			} catch (IOException exception) {
				return null;
			}
		} else {
			return productItemService.update(prI);
		}
	}
	

	@PutMapping("")
	public ProductItem updateFromAdmin(@RequestBody ProductItem prI) {

		String urlImage = prI.getImage();

		Map<String, String> config = new HashMap<>();

		config.put("cloud_name", "dmjh7imwd");
		config.put("api_key", "778777726581776");
		config.put("api_secret", "maiZWuW_V9AF9gIfGJ7ZLHpb3z8");

		Cloudinary cloud = new Cloudinary(config);

		String nameImage = "product_item-image-id-" + prI.getId();
		@SuppressWarnings("rawtypes")
		Map params = ObjectUtils.asMap("public_id", nameImage, // Nếu trùng tên cũ sẽ ghi đè
				"overwrite", true, "upload_preset", "cougarstrore");

		try {
			Object res = cloud.uploader().upload(urlImage, params);
			// URL để lưu vào database
			@SuppressWarnings("unchecked")
			String urlUploaded = ((Map<String, String>) res).get("url")
					.replace("http://res.cloudinary.com/dmjh7imwd/image/upload/", "");

			prI.setImage(urlUploaded);
			return productItemService.update(prI);
		} catch (IOException exception) {
			return null;
		}
	}
	
	
	@PutMapping("/{id}")
	public ProductItem update(@PathVariable("id") Integer id, @RequestBody ProductItem prI) {
		return productItemService.update(prI);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Integer id) {
		productItemService.delete(id);
	}

	@GetMapping("")
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
