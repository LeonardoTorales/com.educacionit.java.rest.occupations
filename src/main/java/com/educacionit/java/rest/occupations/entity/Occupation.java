
package com.educacionit.java.rest.occupations.entity;


import java.io.Serializable;

import org.springframework.data.annotation.Id;


public class Occupation implements Serializable {


	@Id
	private String id;

	private String name;

	private String description;

	private boolean enabled;


	private static final long serialVersionUID = 7528129259859212248L;
	
	
	public Occupation () {
			
		super ();
	}

	public Occupation (String id, String name, String description,
					   boolean enabled) {
			
		super ();
			
		this.id   = id;
		this.name = name;
		this.description = description;
		this.enabled = enabled;
	}

    public String getId () {

        return this.id;
    }


    public void setId (String id) {

        this.id = id;
    }

    public String getName () {

        return this.name;
    }

    public void setName (String name) {

	    this.name = name;
    }

    public String getDescription () {

        return this.description;
    }

    public void setDescription (String description) {

        this.description = description;
    }

    public boolean isEnabled () {

        return this.enabled;
    }

    public void setEnabled (boolean enabled) {

        this.enabled = enabled;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#hashCode ()
     */
 	@Override
 	public int hashCode () {
 			
 		// Return the value.
 		int hash = 0;  
 	    hash += (this.getId () != null ? this.getId ().hashCode () : 0);  
         	  
 	    // Return the new value.
 	    return hash;
 	}

 	/* (non-Javadoc)
 	 * @see java.lang.Object#equals (java.lang.Object)
 	 */
 	@Override
 	public boolean equals (Object object) {
 			
 		// Return the value.
 		if (this == object)  {
 			return true;
 		}
 	              
 	    if (object == null) {
 	       	return false;
 	    }  
 	              
 	    if (getClass () != object.getClass ()) {
 	        return false;
 	    }  
 	              
 	    // Check the classes.
 	    Occupation other = (Occupation) object;
 	    if (!this.id.equals (other.getId ())) {  
             return false;  
         }  
 	        
 	    // Return the value.
 	    return true; 
 	}

 	/* (non-Javadoc)
 	 * @see java.lang.Object#toString ()
 	 */
 	@Override
 	public String toString () {

 		if (this.id != null) {
 			return String.format ("Occupation [%s]", this.name);
 		} else {
            return String.format ("Occupation [#]");
 		} 
 	}
}