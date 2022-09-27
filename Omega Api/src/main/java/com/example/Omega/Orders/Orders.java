package com.example.Omega.Orders;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Omega.login.SqlConnection;

@RestController
public class Orders {

    @GetMapping("/orders")
    public List<Map<String, String>> getOrders() {
        try {
            Statement Conn = new SqlConnection().getConn();
            ResultSet rs = Conn.executeQuery("select * from omega.orders");
            return convertResultSetToJSON(rs);
        } catch (Exception e) {
            return new ArrayList<>();
        }

    }

    public static List<Map<String, String>> convertResultSetToJSON(ResultSet resultSet) throws Exception {

        List<Map<String, String>> result = new ArrayList<>();

        if (resultSet != null) {
            while (resultSet.next()) {
                int total_rows = resultSet.getMetaData().getColumnCount();
                Map<String, String> obj = new HashMap<String, String>();

                for (int i = 0; i < total_rows; i++) {
                    int colNextIndex = i + 1;
                    obj.put(resultSet.getMetaData().getColumnLabel(colNextIndex).toLowerCase(),
                            resultSet.getString(colNextIndex));
                }
                result.add(obj);
            }
        }

        return result;
    }
}
