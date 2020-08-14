
package acme.features.entrepreneur.investmentRound;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.customisations.Customisation;
import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.framework.components.Errors;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractUpdateService;

@Service
public class EntrepreneurInvestmentRoundUpdateService implements AbstractUpdateService<Entrepreneur, InvestmentRound> {

	@Autowired
	EntrepreneurInvestmentRoundRepository repository;


	@Override
	public boolean authorise(final Request<InvestmentRound> request) {
		assert request != null;
		boolean result;

		int id;
		InvestmentRound investmentRound;
		Entrepreneur entrepreneur;
		Principal principal;

		principal = request.getPrincipal();
		id = request.getModel().getInteger("id");
		investmentRound = this.repository.findOneInvestmentRoundById(id);
		entrepreneur = investmentRound.getEntrepreneur();
		result = entrepreneur.getUserAccount().getId() == principal.getAccountId();

		return result;
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

		request.unbind(entity, model, "ticker", "kindRound", "title", "description", "amountMoney", "link");
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

		Customisation customisation = this.repository.findCustomisation();
		String[] CustomisationParameter;
		Integer n = 0;

		int id;
		Double sumBudget;

		// Spam título
		if (!errors.hasErrors("title")) {

			Double spam = Double.valueOf(entity.getTitle().split(" ").length) * customisation.getThreshold() / 100.0;

			CustomisationParameter = customisation.getSpamwords().split(",");

			for (String s : CustomisationParameter) {
				String l = entity.getTitle().toLowerCase();
				int i = l.indexOf(s);
				while (i != -1) {
					n++;
					l = l.substring(i + 1);
					i = l.indexOf(s);
				}
				errors.state(request, n <= spam, "title", "entrepreneur.investment-round.form.error.tituloConSpam");

				if (n > spam) {
					break;
				}
			}

		}

		// Spam descripción
		if (!errors.hasErrors("description")) {

			Double spam = Double.valueOf(entity.getDescription().split(" ").length) * customisation.getThreshold() / 100.0;

			CustomisationParameter = customisation.getSpamwords().split(",");

			for (String s : CustomisationParameter) {
				String l = entity.getDescription().toLowerCase();
				int i = l.indexOf(s);
				while (i != -1) {
					n++;
					l = l.substring(i + 1);
					i = l.indexOf(s);
				}
				errors.state(request, n <= spam, "description", "entrepreneur.investment-round.form.error.descripcionConSpam");

				if (n > spam) {
					break;
				}
			}

		}

		// Dinero incorrecto
		if (!errors.hasErrors("amountMoney")) {
			errors.state(request, entity.getAmountMoney().getCurrency().equals("EUR") || entity.getAmountMoney().getCurrency().equals("€"), "amountMoney", "entrepreneur.investment-round.form.error.dineroIncorrecto");
		}

		//		// SumBudget incorrecto
		//		if (!errors.hasErrors("budget")) {
		//			id = request.getModel().getInteger("id");
		//			sumBudget = this.repository.sumBudgetWorkProgramme(id);
		//			if (sumBudget == null) {
		//				sumBudget = 0.;
		//			}
		//			errors.state(request, sumBudget.equals(entity.getAmountMoney().getAmount()) || !request.getModel().getBoolean("finalMode"), "ticker", "entrepreneur.investment-round.form.error.sumBudget");
		//		}

	}

	@Override
	public void update(final Request<InvestmentRound> request, final InvestmentRound entity) {
		assert request != null;
		assert entity != null;

		this.repository.save(entity);
	}

}
