package application.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import application.entities.CatItem;
import application.entities.Customer;
import application.entities.Executor;
import application.entities.Offer;
import application.proxies.CatProxy;
import application.proxies.OrderProxy;
import application.services.repositories.CatItemDAO;
import application.services.repositories.CustomerDAO;
import application.services.repositories.ExecutorDAO;
import application.services.repositories.OfferDAO;

@RestController

public class OrdersControllerImpl implements OrdersController {

	@Autowired
	private CatItemDAO cat;

	@Autowired
	private OfferDAO offer;

	@Autowired
	private CustomerDAO cust;

	@Autowired
	private ExecutorDAO ex;

	final String lanRu = "RU";
	final String lanHe = "HE";

	@Override
	public ResponseEntity<Object> saveOrder(String json) {
		try {
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(LocalDate.class, new application.services.LocalDateJsonAdapter().nullSafe())
				.create();
		OrderProxy p = gson.fromJson(json, OrderProxy.class);
		Offer o = proxyToOffer(p);
			Offer res = offer.save(o);
			return new ResponseEntity<Object>(res.getId(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	private Offer proxyToOffer(OrderProxy o) {
		Offer e = new Offer();
		e.setId(o.getId());
		e.setPlace(o.getAddress());
		// получить широту и долготу
		e.setCustomerId(o.getCustomerId());
		e.setExecutorId(o.getExecutorId());
		e.setNotes(o.getNotes());
		e.setOrderDateBegin(o.getOrderDateBegin());
		e.setOrderDateEnd(o.getOrderDateEnd());
		e.setPrice(o.getPrice());
		// Optional<CatItem> i = cat.findById(o.getServiceId());
		e.setServiceId(o.getServiceId());

		e.setStatus(o.getStatus());
		e.setAddOptions(o.getAddOptions());
		return e;
	}

	@Override
	public ResponseEntity<Object> getsCategories(String lang, Long parentKey) {
		Set<CatProxy> resList = new HashSet<CatProxy>();
		try {
			Set<CatItem> res=cat.findByParentKeyOrderById(parentKey);
			for( CatItem r :res) {
				CatProxy ncat = new CatProxy(r.getId());
				if (lang.equalsIgnoreCase(lanRu)) {
					ncat.setName(r.getValueRu());
				} else {
					ncat.setName(r.getValueHe());
				}
				ncat.setAddInfo(r.getAddInfo());
				resList.add(ncat);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Object>(resList, HttpStatus.OK);
	}

	/**
	 * @param o
	 * @param lang
	 * @param customerId задан если выборка по инициатору
	 * @param executorId задан если выборка по исполнителю
	 * @return
	 */
	private OrderProxy offerToProxy(Offer o, String lang, Long customerId, Long executorId) {
		OrderProxy pr = new OrderProxy();
		pr.setId(o.getId());
		pr.setAddress(o.getPlace());
		pr.setCustomerId(o.getCustomerId());

		if (customerId != null) {
			Optional<Customer> c = cust.findById(o.getCustomerId());
			if (c.isPresent()) {
				pr.setCustomer(c.get().getName());
			}
		}
		if (executorId != null) {
			pr.setExecutorId(o.getExecutorId());
			Optional<Executor> c = ex.findById(o.getExecutorId());
			if (c.isPresent()) {
				pr.setExecutor(c.get().getName());
			}
		}
		pr.setNotes(o.getNotes());
		pr.setOrderDateBegin(o.getOrderDateBegin());
		pr.setOrderDateEnd(o.getOrderDateEnd());
		pr.setPrice(o.getPrice());
		Optional<CatItem> i = cat.findById(o.getServiceId());
		if (i.isPresent()) {
			if (lang.equalsIgnoreCase(lanRu)) {
				pr.setService(i.get().getValueRu());
			} else {
				pr.setService(i.get().getValueHe());
			}

		}
		pr.setStatus(o.getStatus());
		pr.setAddOptions(o.getAddOptions());
		return pr;
	}

	@Override
	public ResponseEntity<Object> getOrdersbyCustomer(String language, Long userid, int pageNo, Integer pageSize,String isnew) {
		List<OrderProxy> res=new ArrayList<OrderProxy>();
		try {
			if (pageNo < 0)
				pageNo = 0;
		PageRequest p = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, "id"));
		Page<Offer>  resE = offer.findByCustomerId(userid, p);
		for (Offer o:resE.getContent()) {
		 res.add(offerToProxy( o,  language, userid,null));
			}
			PageResponse result = new PageResponse(res, resE.getTotalPages(), resE.getTotalElements());
		return new ResponseEntity<Object>(result, HttpStatus.OK);
	} catch (Exception e) {
		e.printStackTrace();
		return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	}

	@Override
	public ResponseEntity<Object> getOrdersbyExecutor(String language, Long userid, int pageNo, Integer pageSize) {

		List<OrderProxy> res = new ArrayList<OrderProxy>();
		try {
			if (pageNo < 0)
				pageNo = 0;
			PageRequest p = PageRequest.of(pageNo, pageSize, Sort.by(Sort.Direction.DESC, "id"));
			Page<Offer> resE = offer.findByExecutorId(userid, p);

			for (Offer o : resE.getContent()) {
				res.add(offerToProxy(o, language, null, userid));
			}
			PageResponse result = new PageResponse(res, resE.getTotalPages(), resE.getTotalElements());
			return new ResponseEntity<Object>(result, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
