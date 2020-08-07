
package acme.features.administrator.chart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.forms.Chart;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorChartShow implements AbstractShowService<Administrator, Chart> {

	@Autowired
	AdministratorChartRepository repository;


	@Override
	public boolean authorise(final Request<Chart> request) {
		assert request != null;
		return true;
	}

	@Override
	public void unbind(final Request<Chart> request, final Chart entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "numberOfTechonologiesGroupedBySector", "numberOfToolsGroupedBySector");
		request.unbind(entity, model, "ratioOfTechnologiesGroupedByStatus", "ratioOfToolsGroupedByStatus");
		request.unbind(entity, model, "ratioOfInvestmentRoundGroupedByKindRound", "ratioOfApplicationsGroupedByStatement");
		
	}

	@Override
	public Chart findOne(final Request<Chart> request) {
		assert request != null;


		Chart d = new Chart();
		Object[] companiesBySector = this.repository.findTechnologiesSector();
		d.setNumberOfTechonologiesGroupedBySector(companiesBySector);
		Object[] investorsBySector = this.repository.findToolsSector();
		d.setNumberOfToolsGroupedBySector(investorsBySector);
		Object[] technologiessByStatus = this.repository.findTechnologiesStatus();
		d.setRatioOfTechnologiesGroupedByStatus(technologiessByStatus);
		Object[] toolsByStatus = this.repository.findToolsStatus();
		d.setRatioOfToolsGroupedByStatus(toolsByStatus);
		Object[] investmentRoundByKindRound = this.repository.findInvestmentRoundKindRound();
		d.setRatioOfInvestmentRoundGroupedByKindRound(investmentRoundByKindRound);
		Object[] applicationsByStatement = this.repository.findApplicationStatement();
		d.setRatioOfApplicationsGroupedByStatement(applicationsByStatement);
		
		return d;
	}


}
