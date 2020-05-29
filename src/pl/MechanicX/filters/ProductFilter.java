package pl.MechanicX.filters;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import pl.MechanicX.beans.xStatus;
import pl.MechanicX.service.xStatusService;

public class ProductFilter {
	xStatusService productService = xStatusService.getInstance();
	
	public void filterProductsById(HttpServletRequest request, HttpServletResponse response, String searchPhrase) {
		List<xStatus> statusx = new ArrayList<xStatus>();
		HttpSession session = request.getSession();
		try {
			statusx.add(productService.getProduct(Integer.parseInt(searchPhrase)));
		}catch(NumberFormatException e) {
			System.out.println("filtrowanie ID s³owem");
		}
		session.setAttribute("statusxList", statusx);
   		request.setAttribute("prodcutsList", statusx);
	}
	
	public void filterProductsByName(HttpServletRequest request, HttpServletResponse response, String searchPhrase) {
		List<xStatus> statusx = productService.getAllProductsBySearch(searchPhrase);
		HttpSession session = request.getSession();
		session.setAttribute("statusxList", statusx);
   		request.setAttribute("statusxList", statusx);
	}
	
	public void filterProductsByType(HttpServletRequest request, HttpServletResponse response, String searchPhrase) {
		List<xStatus> statusx = productService.getAllProductsByType(searchPhrase);
		HttpSession session = request.getSession();
		session.setAttribute("statusxList", statusx);
   		request.setAttribute("statusxList", statusx);
	}
}
