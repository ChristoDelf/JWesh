package org.jwesh.action.mapping;

public class Mapping {
	
	private HttpMethod method;
	private String url;
	
	public Mapping(HttpMethod method, String url) {
		this.method = method;
		this.url = url;
	}
	
	// On construit l'objet brique par brique
//	public class Builder {
//		private Mapping mapping = new Mapping();
//		public Builder withMethodGet() {
//			mapping.method = HttpMethod.GET;
//			return this;
//		}
//		public Builder withUrl(String url) {
//			mapping.url = url;
//			return this;
//		}
//		public Mapping build() {
//			//TODO : ajouter une exception si l'objet n'est pas complet
//			return mapping;
//		}
//	}
	
	// Factory qui crée un objet (en une méthode)
	public static Mapping get(String url) {
		return new Mapping(HttpMethod.GET, url);
	}

	public static Mapping post(String url) {
		return new Mapping(HttpMethod.POST, url);
	}

	public static Mapping put(String url) {
		return new Mapping(HttpMethod.PUT, url);
	}

	public static Mapping patch(String url) {
		return new Mapping(HttpMethod.PATCH, url);
	}

	public static Mapping delete(String url) {
		return new Mapping(HttpMethod.DELETE, url);
	}

	public HttpMethod getMethod() {
		return method;
	}

	public void setMethod(HttpMethod method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((method == null) ? 0 : method.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Mapping)) {
			return false;
		}
		Mapping other = (Mapping) obj;
		if (method != other.method) {
			return false;
		}
		if (url == null) {
			if (other.url != null) {
				return false;
			}
		} else if (!url.equals(other.url)) {
			return false;
		}
		return true;
	}
}
