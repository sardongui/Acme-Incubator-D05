
package acme.features.bookkeeper.accountingRecord;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.accountingRecords.AccountingRecord;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Bookkeeper;
import acme.features.bookkeeper.investment.BookkeeperInvestmentRepository;
import acme.framework.services.AbstractCreateService;

import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;

@Service
public class BookkeeperAccountingRecordCreateService implements AbstractCreateService<Bookkeeper, AccountingRecord> {

	// Internal state ---------------------------------------------------------

	@Autowired
	private BookkeeperAccountingRecordRepository repository;
	
	private BookkeeperInvestmentRepository investmentRepository;



	@Override
	public boolean authorise(final Request<AccountingRecord> request) {
		assert request != null;

		return request.getPrincipal().hasRole(Bookkeeper.class);
	}

	@Override
	public void bind(final Request<AccountingRecord> request, final AccountingRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors, "creationMoment");
	}

	@Override
	public void unbind(final Request<AccountingRecord> request, final AccountingRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		model.setAttribute("finalMode", false);
		model.setAttribute("bookkeeperid", request.getPrincipal().getActiveRoleId());
		model.setAttribute("idinvestmentRound", request.getModel().getInteger("investmentRoundId"));
		request.unbind(entity, model, "body", "finalMode", "title");

	}

	@Override
	public AccountingRecord instantiate(final Request<AccountingRecord> request) {
		assert request != null;
		AccountingRecord result;
		result = new AccountingRecord();
		Date moment;

		InvestmentRound investmentRound = this.investmentRepository.findOneById(request.getModel().getInteger("investment-roundId"));
		result.setInvestmentRound(investmentRound);
		Bookkeeper bookkeeper = this.repository.findBookkeeperById(request.getPrincipal().getActiveRoleId());
		result.setBookkeeper(bookkeeper);
		moment = new Date(System.currentTimeMillis() - 1);
		result.setCreationMoment(moment);
		return result;
	}

	@Override
	public void validate(final Request<AccountingRecord> request, final AccountingRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public void create(final Request<AccountingRecord> request, final AccountingRecord entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}
}
