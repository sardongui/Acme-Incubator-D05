package acme.features.bookkeeper.accountingRecord;

import org.springframework.beans.factory.annotation.Autowired;

import acme.entities.accountingRecords.AccountingRecord;
import acme.entities.roles.Bookkeeper;

import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

public class BookkeeperAccountingRecordUpdateService implements AbstractUpdateService<Bookkeeper, AccountingRecord>{

	@Autowired
	BookkeeperAccountingRecordRepository	repository;


	// AbstractListService<Administrator, Announcement> interface ------------------------------


	@Override
	public boolean authorise(final Request<AccountingRecord> request) {
		assert request != null;
		int arId;
		Boolean result;
		AccountingRecord ar;
		Bookkeeper bookkeeper;
		Principal principal;

		arId = request.getModel().getInteger("id");
		ar = this.repository.findOneById(arId);
		bookkeeper = ar.getBookkeeper();
		principal = request.getPrincipal();

		result = bookkeeper.getId() == principal.getActiveRoleId() && !ar.isFinalMode();

		return result;
	}

	@Override
	public void bind(final Request<AccountingRecord> request, final AccountingRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

		request.bind(entity, errors);
	}

	@Override
	public void unbind(final Request<AccountingRecord> request, final AccountingRecord entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "body", "finalMode", "title", "invesmentRound", "bookkeeper");

	}

	@Override
	public void validate(final Request<AccountingRecord> request, final AccountingRecord entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;

	}

	@Override
	public AccountingRecord findOne(final Request<AccountingRecord> request) {
		assert request != null;

		AccountingRecord result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

	@Override
	public void update(final Request<AccountingRecord> request, final AccountingRecord entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);

	}

}
