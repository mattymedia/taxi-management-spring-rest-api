package co.com.taximanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.com.taximanagement.entities.DailyReport;

public interface IDailyReportRepository extends JpaRepository<DailyReport, Integer> {

}
