package application.proxies;

import java.time.LocalDateTime;

import application.entities.OrderStatus;

/*"id": 1,
"service": "Мойка авто",
"orderDate": "11-07-2021 12:00 - 18:00",
"addOptions": "Полная мойка;Минивэн",
"notes": "С воском и хомером для уточек",
"customer": "Вася",
"address": "Хайфа, ул.Бен-Гурион, 63"*/
public class OrderProxy {
	private LocalDateTime orderDateBegin;
	private LocalDateTime orderDateEnd;
	private Float price = (float) 0;
	private String notes;
	private OrderStatus status;
	private String service;// CatItem
	private Long serviceId;
	private String addOptions;// from CatItem
	private Long id;
	private String address;
	private String customer;
	private Long customerId;
	private String executor;
	private Long executorId;

	public LocalDateTime getOrderDateBegin() {
		return orderDateBegin;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getExecutor() {
		return executor;
	}

	public void setExecutor(String executor) {
		this.executor = executor;
	}

	public Long getExecutorId() {
		return executorId;
	}

	public void setExecutorId(Long executorId) {
		this.executorId = executorId;
	}

	public void setOrderDateBegin(LocalDateTime orderDateBegin) {
		this.orderDateBegin = orderDateBegin;
	}

	public LocalDateTime getOrderDateEnd() {
		return orderDateEnd;
	}

	public void setOrderDateEnd(LocalDateTime orderDateEnd) {
		this.orderDateEnd = orderDateEnd;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getAddOptions() {
		return addOptions;
	}

	public void setAddOptions(String addOptions) {
		this.addOptions = addOptions;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}
}
