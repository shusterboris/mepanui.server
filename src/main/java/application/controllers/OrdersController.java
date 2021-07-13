package application.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
public interface OrdersController {
	@GetMapping({ "/categories/{language}/{parentKey}" })
	public ResponseEntity<Object> getsCategories(@PathVariable(name = "language", required = true) String language,
			@PathVariable(name = "parentKey", required = true) Long parentKey);

	@GetMapping({ "/orders/customer/{language}/{userid}/{page}/{pageSize}/{new}" })
	public ResponseEntity<Object> getOrdersbyCustomer(@PathVariable(name = "language", required = true) String language,
			@PathVariable(name = "userid", required = true) Long userid,
			@PathVariable(name = "page") int page, 
			@PathVariable(name = "pageSize", required = false) Integer pageSize,
			@PathVariable(name = "new", required = false) String isnew);

	@GetMapping({ "/orders/executor/{language}/{userid}/{page}/{pageSize}" })
	public ResponseEntity<Object> getOrdersbyExecutor(@PathVariable(name = "language", required = true) String language,
			@PathVariable(name = "userid", required = true) Long userid,
			@PathVariable(name = "page") int page, @PathVariable(name = "pageSize", required = false) Integer pageSize);

	@PostMapping("/order/save")
	public ResponseEntity<Object> saveOrder(@RequestBody String json);

}

