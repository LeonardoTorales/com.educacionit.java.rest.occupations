
package com.educacionit.java.rest.occupations.controller;


import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.educacionit.java.rest.occupations.entity.Occupation;
import com.educacionit.java.rest.occupations.repository.IOccupationRepository;


@RestController
@RequestMapping ("occupation")
public class OccupationController {


	private IOccupationRepository occupationRepository;


	public OccupationController() {

		super ();
	}

	@Autowired
	public void setProductRepository (IOccupationRepository occupationRepository) {

		this.occupationRepository = occupationRepository;
	}


	@RequestMapping (method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> get () {

    	// Return the value.
    	return ResponseEntity.ok (this.occupationRepository.findAll ());
    }

	@RequestMapping (value = "/{id}", method = RequestMethod.GET, produces={MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> get (@PathVariable ("id") String id) {


        Occupation p = this.occupationRepository.findOne (id);

		if (p == null) {
            return ResponseEntity.notFound ().build ();
        } else {
            return ResponseEntity.ok (p);
        }
	}

    @RequestMapping (method = RequestMethod.POST, consumes={MediaType.APPLICATION_JSON_VALUE},
                                                  produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
	public ResponseEntity<?> save (@RequestBody Map<String, Object> data) {

	    try {

	        Occupation p = new Occupation();
	        p.setName ((String)data.get ("name"));
            p.setDescription ((String)data.get ("description"));
            p.setEnabled ((Boolean)data.get ("enabled"));

	        this.occupationRepository.save (p);

        } catch (Exception e) {

            return ResponseEntity.badRequest ().build ();
        }

        return ResponseEntity.noContent().build ();
    }

    @RequestMapping (value="/{id}", method = RequestMethod.PUT, consumes={MediaType.APPLICATION_JSON_VALUE},
                                                                produces={MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResponseEntity<?> save (@RequestBody Map<String, Object> data, @PathVariable ("id") String id) {

        try {

            Occupation p = new Occupation();
            p.setId (id);
            p.setName ((String)data.get ("name"));
            p.setDescription ((String)data.get ("description"));
            p.setEnabled ((Boolean)data.get ("enabled"));

            this.occupationRepository.save (p);

        } catch (Exception e) {

            return ResponseEntity.unprocessableEntity().build ();
        }

        return ResponseEntity.noContent().build ();
    }

    @RequestMapping (value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete (@PathVariable ("id") String id) {

	    this.occupationRepository.delete (id);

        return ResponseEntity.noContent ().build ();
    }
}