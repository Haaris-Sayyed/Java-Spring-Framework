package main.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import main.model.Offer;
import main.model.OfferDTO;
import main.repository.OfferRepository;

@Service
public class OfferServiceImpl implements OfferService {

	@Autowired
	private OfferRepository offerRepository;
	
	@Override
	public List<Offer> getAll() {
		return offerRepository.findAll();
	}

	@Override
	public Offer getById(int id) {
		return offerRepository.getOne(id);
	}

	@Override
	public void saveOrUpdate(Offer offer) {
		if(offer.getId() == 0) {
			offer.setCreationDate(new Date());
		}
		offerRepository.save(offer);
	}

	@Override
	public void delete(int id) {
		offerRepository.deleteById(id);
	}

	@Override
	public List<OfferDTO> getAllDTO() {
		List<Offer> offers = getAll();
		List<OfferDTO> offersDTO = offers.stream()
				.map(o -> new OfferDTO(o.getId(), o.getCode(), o.getName(), o.getDuration(), false, "Local offer"))
				.collect(Collectors.toList());
		return offersDTO;
	}

}
