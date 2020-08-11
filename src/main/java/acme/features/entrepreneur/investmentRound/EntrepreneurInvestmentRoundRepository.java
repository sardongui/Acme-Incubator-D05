
package acme.features.entrepreneur.investmentRound;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.investmentRounds.InvestmentRound;
import acme.entities.roles.Entrepreneur;
import acme.entities.workProgrammes.WorkProgramme;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EntrepreneurInvestmentRoundRepository extends AbstractRepository {

	@Query("select ir from InvestmentRound ir where ir.entrepreneur.id =?1")
	Collection<InvestmentRound> findActivesInvestmentRounds(int entrepeneurId);

	@Query("select ir from InvestmentRound ir where ir.id =?1")
	InvestmentRound findOneInvestmentRoundById(int id);

	@Query("select e from Entrepreneur e where e.id = ?1")
	Entrepreneur findOneEntrepreneurById(int id);

	@Query("select wp from WorkProgramme wp where wp.investmentRound.id = ?1")
	Collection<WorkProgramme> findWorkProgrammesByInvestmentRoundId(int investmentRoundId);

	//	@Query("select f from Forum f where f.investmentRound.id = ?1")
	//	Forum findForumByInvestmentRoundId(int investmentRoundId);
	//
	//	@Query("select ar from AccountingRecord ar where ar.investmentRound.id = ?1")
	//	Collection<AccountingRecord> findAccountingRecordsByInvestmentRoundId(int investmentRoundId);

}
