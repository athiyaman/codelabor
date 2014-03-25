package org.codelabor.example.integration.mci.services;

import java.util.Date;
import java.util.List;

public interface FinancialService {
	@SuppressWarnings("unchecked")
	List search(Date fromDate, Date toDate) throws Exception;
}
