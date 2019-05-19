import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.model.Supplier;
import com.springweb.repository.SupplierRepository;


@Service
public class SupplierDAO {
	
	@Autowired
	SupplierRepository SupplierRepository;
	
	/*to save supplier */
	
	public Supplier save(Supplier sid) {
		return SupplierRepository.save(sid);
	}
	
	/* search all supplier*/
	public List<Supplier> findAll(){
		return SupplierRepository.findAll();
	}

	/*get an supplier by id*/
	public Supplier findone(Long sid) {
		return SupplierRepository.findOne(sid);
	}
	
	/*delete an supplier*/
	
	public void delete (Supplier sid) {
		SupplierRepository.delete(sid);
	}
	
	
	

}
