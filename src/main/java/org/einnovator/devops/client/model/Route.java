package org.einnovator.devops.client.model;

import java.util.ArrayList;
import java.util.List;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Route extends EntityBase {

	private String host;
	
	private Domain domain;

	private String dns;

	private Boolean tls;
	
	private Certificate certificate;
	
	private String url;
	
	private Boolean primary;

	private String ingress;
	
	private Boolean sharedIngress;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code Route}.
	 *
	 */
	public Route() {
	}
		
	//
	// Getters/Setters
	//

	/**
	 * Get the value of property {@code host}.
	 *
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * Set the value of property {@code host}.
	 *
	 * @param host the host
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * Get the value of property {@code domain}.
	 *
	 * @return the domain
	 */
	public Domain getDomain() {
		return domain;
	}

	/**
	 * Set the value of property {@code domain}.
	 *
	 * @param domain the domain
	 */
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	
	/**
	 * Get the value of property {@code dns}.
	 *
	 * @return the dns
	 */
	public String getDns() {
		return dns;
	}

	/**
	 * Set the value of property {@code dns}.
	 *
	 * @param dns the dns
	 */
	public void setDns(String dns) {
		this.dns = dns;
	}

	/**
	 * Get the value of property {@code tls}.
	 *
	 * @return the tls
	 */
	public Boolean getTls() {
		return tls;
	}

	/**
	 * Set the value of property {@code tls}.
	 *
	 * @param tls the tls
	 */
	public void setTls(Boolean tls) {
		this.tls = tls;
	}

	/**
	 * Get the value of property {@code certificate}.
	 *
	 * @return the certificate
	 */
	public Certificate getCertificate() {
		return certificate;
	}

	/**
	 * Set the value of property {@code certificate}.
	 *
	 * @param certificate the certificate
	 */
	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	/**
	 * Get the value of property {@code url}.
	 *
	 * @return the value of {@code url}
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * Set the value of property {@code url}.
	 *
	 * @param url the value of {@code url}
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * Get the value of property {@code primary}.
	 *
	 * @return the value of {@code primary}
	 */
	public Boolean getPrimary() {
		return primary;
	}

	/**
	 * Set the value of property {@code primary}.
	 *
	 * @param primary the value of {@code primary}
	 */
	public void setPrimary(Boolean primary) {
		this.primary = primary;
	}

	/**
	 * Get the value of property {@code ingress}.
	 *
	 * @return the value of {@code ingress}
	 */
	public String getIngress() {
		return ingress;
	}

	/**
	 * Set the value of property {@code ingress}.
	 *
	 * @param ingress the value of {@code ingress}
	 */
	public void setIngress(String ingress) {
		this.ingress = ingress;
	}

	/**
	 * Get the value of property {@code sharedIngress}.
	 *
	 * @return the value of {@code sharedIngress}
	 */
	public Boolean getSharedIngress() {
		return sharedIngress;
	}

	/**
	 * Set the value of property {@code sharedIngress}.
	 *
	 * @param sharedIngress the value of {@code sharedIngress}
	 */
	public void setSharedIngress(Boolean sharedIngress) {
		this.sharedIngress = sharedIngress;
	}

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("host", host)
				.append("domain", domain)
				.append("dns", dns)
				.append("tls", tls)
				.append("url", url)
				.append("ingress", ingress)
				.append("sharedIngress", sharedIngress)
				.append("certificate", certificate)
				;
	}
	
	public static Route makeRoute(String dns) {
		Route route = new Route();
		int i = dns.indexOf('.');
		String host = dns;
		if (i>1) {
			host = dns.substring(0, i);
		}
		route.setHost(host);
		route.setDns(dns);
		return route;
	}

	public Certificate getRequiredCertificate() {
		if (certificate!=null) {
			return certificate;
		}
		if (domain!=null) {
			if (domain.getCertificate()!=null) {
				return domain.getCertificate();
			}
		}
		return null;
	}
	
	public static List<Route> makeRoute(List<String> dns) {
		if (dns==null) {
			return null;
		}
		List<Route> routes = new ArrayList<>();
		for (String dns1: dns) {
			routes.add(makeRoute(dns1));
		}
		return routes;
	}

	public static Route findPrimary(List<Route> routes, boolean required) {
		if (routes!=null && routes.size()>0) {
			for (Route route : routes) {
				if (Boolean.TRUE.equals(route.getPrimary())) {
					return route;
				}
			}
			if (required) {
				return routes.get(0);				
			}
		}
		return null;
	}

}
