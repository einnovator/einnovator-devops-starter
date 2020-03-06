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
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code Binding}.
	 *
	 */
	public Route() {
	}
	
	public Route(String host, Domain domain, Boolean tls) {
		this.host = host;
		this.domain = domain;
		this.tls = tls;
		makeDns();
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
	 * @param host the host to set
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
	 * @param domain the domain to set
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
	 * @param dns the dns to set
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
	 * @param tls the tls to set
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
	 * @param certificate the certificate to set
	 */
	public void setCertificate(Certificate certificate) {
		this.certificate = certificate;
	}

	public void normalize() {
		if (host!=null) {
			dns = makeDns();		
		}
	}

	public String makeDns() {
		StringBuilder sb = new StringBuilder();
		sb.append(host);
		if (domain!=null) {
			if (domain.getDns()==null) {
				domain.normalize();				
			}
			if (domain.getDns()!=null) {				
				sb.append(".");
				sb.append(domain.getDns());			
			}
		}
		return sb.toString();
	}
	
	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator)
				.append("host", host)
				.append("domain", domain)
				.append("dns", dns)
				.append("tls", tls)
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

	public String getRequiredDns() {
		if (dns!=null) {
			return dns;
		}
		return makeDns();
	}

	public String getHttpUri() {
		return "http://" + getRequiredDns();
	}

	public String getHttpsUri() {
		return "https://" + getRequiredDns();
	}

	public String getWebUri() {
		return Boolean.TRUE.equals(tls) ? getHttpsUri() : getHttpUri();
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

}
