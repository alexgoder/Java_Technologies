package com.example;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CarDAO {

    private JdbcTemplate jdbcTemplate;

    public CarDAO(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void addCar(Car car) {
        String sql = "INSERT INTO cars (registration_number, brand, year_of_fabrication, color, km) VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, car.getRegistrationNumber(), car.getBrand(), car.getYearOfFabrication(), car.getColor(), car.getKm());
    }

    public void deleteCar(String registrationNumber) {
        String sql = "DELETE FROM cars WHERE registration_number = ?";
        jdbcTemplate.update(sql, registrationNumber);
    }

    public Car searchCar(String registrationNumber) {
        String sql = "SELECT * FROM cars WHERE registration_number = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{registrationNumber}, new CarRowMapper());
    }

    public List<Car> getAllCars() {
        String sql = "SELECT * FROM cars";
        return jdbcTemplate.query(sql, new CarRowMapper());
    }

    public int countCarsByBrand(String brand) {
        String sql = "SELECT COUNT(*) FROM cars WHERE brand = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{brand}, Integer.class);
    }

    public int countCarsUnder100kKm() {
        String sql = "SELECT COUNT(*) FROM cars WHERE km < 100000";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<Car> getCarsNewerThan5Years() {
        String sql = "SELECT * FROM cars WHERE year_of_fabrication > (YEAR(CURDATE()) - 5)";
        return jdbcTemplate.query(sql, new CarRowMapper());
    }

    private static class CarRowMapper implements RowMapper<Car> {

        @Override
        public Car mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
            Car car = new Car();
            car.setRegistrationNumber(rs.getString("registration_number"));
            car.setBrand(rs.getString("brand"));
            car.setYearOfFabrication(rs.getInt("year_of_fabrication"));
            car.setColor(rs.getString("color"));
            car.setKm(rs.getInt("km"));
            return car;
        }
    }
}
