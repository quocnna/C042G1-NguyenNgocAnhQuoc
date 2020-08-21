package dao;

import common.BaseCRUD;
import common.Paging;
import model.Product;
import model.ProductDTO;

import java.util.List;

public interface ProductDAO extends BaseCRUD<Product> {
    List<ProductDTO> getAllDTO();

    List<ProductDTO> getAllDTOWithPaging(Paging paging);

    List<ProductDTO> searchDTO(String by, String val);

    List<ProductDTO> searchDTOWithPaging(String by, String val, Paging paging);
}
