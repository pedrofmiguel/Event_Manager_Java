package classes;

public class login {
	private String id;
	private String password;
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + acesslevel;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof login))
			return false;
		login other = (login) obj;
		if (acesslevel != other.acesslevel)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "login [id=" + id + ", password=" + password + ", + ]";
	}

	private int acesslevel = 1;

	public login(String id, String password, int acesslevel) {
		super();
		this.id = id;
		this.password = password;
		this.acesslevel = acesslevel;
	}

	public login(String id, String password) {
		super();
		this.id = id;
		this.password = password;
		this.acesslevel = 1;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the acesslevel
	 */
	public int getAcesslevel() {
		return acesslevel;
	}

	/**
	 * @param acesslevel the acesslevel to set
	 */
	public void setAcesslevel(int acesslevel) {
		this.acesslevel = acesslevel;
	}
}