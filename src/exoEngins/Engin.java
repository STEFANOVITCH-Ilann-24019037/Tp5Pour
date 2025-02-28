package exoEngins;

abstract class Engin  {
	protected static int dernierId = 0;
    protected int id;
    protected Propulsion propulsion;


    //Constructor
    public Engin(Propulsion propulsion) {
        this.propulsion = propulsion;
        id = ++dernierId;
    }

    //Getter/Setter
    public static int getDernierId() {
        return dernierId;
    }
    public Propulsion getPropulsion() {
        return propulsion;
    }
    public void setPropulsion(Propulsion propulsion) {
        this.propulsion = propulsion;
    }

    public int getId() {
        return id;
    }

  
    @Override
	public String toString() {
		return "Engin [id=" + id + "]";
	}

	public abstract void conduire();
}