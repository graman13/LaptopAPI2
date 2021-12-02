package com.myproject.laptop.repository;

import com.myproject.laptop.entity.Laptop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class JDBCRepository {

    @Autowired
    private NamedParameterJdbcTemplate template;
	@Autowired
	private JdbcTemplate jdbc;



    public List<Laptop> getLaps() {
        String query =
                "insert into laptop values(:id,:brand,:model,:price,:ram)";

        String update = "update laptop set brand=:brand, model=:model where id=:id";

		StringBuilder s=new StringBuilder("SELECT * FROM LAPTOP");
		MapSqlParameterSource param=new MapSqlParameterSource();
		//param.addValue("param",String.valueOf(42));

		List<Laptop> lap=template.query(String.valueOf(s),param, rs -> {
			List<Laptop> laptop1=new ArrayList<>();
			while(rs.next()){
				Laptop laptop=new Laptop();
				laptop.setId(rs.getInt(1));
				laptop.setBrand(rs.getString(2));
				laptop.setModel(rs.getString(3));
				laptop.setPrice(rs.getDouble(4));
				laptop.setRam(rs.getString(5));
				laptop1.add(laptop);
			}
			return laptop1;
		});
		return lap;



////	  HashMap<String, Object> map= new HashMap<String,Object>();
////	  map.put("id", lap.getId());
////	  map.put("brand",lap.getBrand());
////	  map.put("model",lap.getModel());
////	  map.put("price",lap.getPrice());
////	  map.put("ram", lap.getRam());
//
//        SqlParameterSource map = new MapSqlParameterSource("id", lap.getId()).addValue("brand", lap.getBrand()).addValue("model", lap.getModel());
//        template.execute(update, map, new PreparedStatementCallback<Object>() {
//
//            @Override
//            public Object doInPreparedStatement(PreparedStatement ps) throws
//                    SQLException, DataAccessException { // TODO Auto-generated method stub return
//                return ps.executeUpdate();
//
//            }
//        });
//
//        return lap;
    }

    /*
     * @Autowired private JdbcTemplate template;
     *
     * public Laptop save(Laptop lap) { String
     * query="insert into laptop values(?,?,?,?,?)";
     *
     * template.execute(query, new PreparedStatementCallback<Boolean>() {
     *
     * @Override public Boolean doInPreparedStatement(PreparedStatement ps) throws
     * SQLException, DataAccessException { // TODO Auto-generated method stub
     * ps.setLong(1, lap.getId()); ps.setString(2, lap.getBrand()); ps.setString(3,
     * lap.getModel()); ps.setDouble(4, lap.getPrice()); ps.setString(5,
     * lap.getRam()); return ps.execute(); }
     *
     * }); return lap; }
     */

}
