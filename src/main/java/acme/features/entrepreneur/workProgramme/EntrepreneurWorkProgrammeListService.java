
package acme.features.entrepreneur.workProgramme;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.entities.workProgrammes.WorkProgramme;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractListService;

@Service
public class EntrepreneurWorkProgrammeListService implements AbstractListService<Entrepreneur, WorkProgramme> {

	@Autowired
	EntrepreneurWorkProgrammeRepository repository;


	@Override
	public boolean authorise(final Request<WorkProgramme> request) {
		assert request != null;
		boolean result;
		int investId;
		InvestmentRound ir;
		Entrepreneur entrepreneur;
		Principal principal;

		investId = request.getModel().getInteger("id");
		ir = this.repository.findAllWorkProgrammeById(investId).stream().findFirst().get().getInvestmentRound();
		entrepreneur = ir.getEntrepreneur();
		principal = request.getPrincipal();
		result = entrepreneur.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<WorkProgramme> request, final WorkProgramme entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "moment");
	}

	@Override
	public Collection<WorkProgramme> findMany(final Request<WorkProgramme> request) {
		assert request != null;

		Collection<WorkProgramme> res;

		res = this.repository.findAllWorkProgrammeById(request.getModel().getInteger("id"));
		return res;
	}

}
