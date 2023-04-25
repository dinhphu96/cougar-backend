package com.cougar.restController;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
import com.cougar.entity.Product;
import com.cougar.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/products")
public class ProductRestController {

	@Autowired
	ProductService productService;

	@GetMapping("")
	public List<Product> getAll() {
		return productService.findAll();
	}

	@GetMapping("/{id}")
	public Product getOne(Model model, @PathVariable("id") Integer id) {
		return productService.findById(id);
	}

	@PostMapping("")
	public Product create(@RequestBody Product pr) {

		if (pr.getId() != null) {
			return productService.save(pr);
		} else {
			
			String urlImage = pr.getImage();
			pr.setImage("change");
			Product prd = productService.save(pr);

			Map<String, String> config = new HashMap<>();

			config.put("cloud_name", "dmjh7imwd");
			config.put("api_key", "778777726581776");
			config.put("api_secret", "maiZWuW_V9AF9gIfGJ7ZLHpb3z8");

			Cloudinary cloud = new Cloudinary(config);

			String nameImage = "product-image-id-" + prd.getId();
			@SuppressWarnings("rawtypes")
			Map params = ObjectUtils.asMap("public_id", nameImage, // Nếu trùng tên cũ sẽ ghi đè
					"overwrite", true, "upload_preset", "cougarstrore");

			try {
				Object res = cloud.uploader().upload(urlImage, params);
				// URL để lưu vào database
				@SuppressWarnings("unchecked")
				String urlUploaded = ((Map<String, String>) res).get("url")
						.replace("http://res.cloudinary.com/dmjh7imwd/image/upload/", "");

				prd.setImage(urlUploaded);
				return productService.update(prd);
			} catch (IOException exception) {
				return null;
			}
		}
	}

	@PutMapping("")
	public Product update(@RequestBody Product pr) {
		String urlImage = pr.getImage();

		Map<String, String> config = new HashMap<>();

		config.put("cloud_name", "dmjh7imwd");
		config.put("api_key", "778777726581776");
		config.put("api_secret", "maiZWuW_V9AF9gIfGJ7ZLHpb3z8");

		Cloudinary cloud = new Cloudinary(config);

		String nameImage = "product-image-id-" + pr.getId();
		@SuppressWarnings("rawtypes")
		Map params = ObjectUtils.asMap("public_id", nameImage, // Nếu trùng tên cũ sẽ ghi đè
				"overwrite", true, "upload_preset", "cougarstrore");

		try {
			Object res = cloud.uploader().upload(urlImage, params);
			// URL để lưu vào database
			@SuppressWarnings("unchecked")
			String urlUploaded = ((Map<String, String>) res).get("url")
					.replace("http://res.cloudinary.com/dmjh7imwd/image/upload/", "");

			pr.setImage(urlUploaded);
			return productService.update(pr);
		} catch (IOException exception) {
			return null;
		}
	}

	@DeleteMapping("/rest/products/{id}")
	public void delete(@PathVariable("id") Integer id) {
		productService.delete(id);
	}
}
