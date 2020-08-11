
package acme.features.entrepreneur.investmentRound;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// import acme.entities.accountingRecords.AccountingRecord;
// import acme.entities.forums.Forum;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.entities.workProgrammes.WorkProgramme;
import acme.features.authenticated.forum.AuthenticatedForumRepository;
import acme.features.entrepreneur.workProgramme.EntrepreneurWorkProgrammeRepository;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.services.AbstractDeleteService;

@Service
public class EntrepreneurInvestmentRoundDeleteService implements AbstractDeleteService<Entrepreneur, InvestmentRound> {

	@Autowired
	EntrepreneurInvestmentRoundRepository	repository;

	@Autowired
	EntrepreneurWorkProgrammeRepository		workProgrammeRepository;

	@Autowired
	AuthenticatedForumRepository			forumRepository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;
		return true;
	}

	@Override
	public void bind(final Request<InvestmentRound> request, final InvestmentRound entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<InvestmentRound> request, final InvestmentRound entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "ticker", "moment", "kindRound", "title", "description", "amountMoney", "link");
	}

	@Override
	public InvestmentRound findOne(final Request<InvestmentRound> request) {
		assert request != null;
		InvestmentRound result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneInvestmentRoundById(id);
		return result;
	}

	@Override
	public void validate(final Request<InvestmentRound> request, final InvestmentRound entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
	}

	@Override
	public void delete(final Request<InvestmentRound> request, final InvestmentRound entity) {
		assert request != null;
		assert entity != null;

		Collection<WorkProgramme> workProgrammes = this.repository.findWorkProgrammesByInvestmentRoundId(entity.getId());
		for (WorkProgramme wp : workProgrammes) {
			this.workProgrammeRepository.delete(wp);
		}

		//		Forum forum = this.repository.findForumByInvestmentRoundId(entity.getId());
		//		this.forumRepository.delete(forum);
		//
		//		Collection<AccountingRecord> accountingRecords = this.repository.findAccountingRecordsByInvestmentRoundId(entity.getId());
		//		for (AccountingRecord ar : accountingRecords) {
		//			this.workProgrammeRepository.delete(ar);
		//		}

		this.repository.delete(entity);
	}

}
