package com.ds.quickOrder;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.ds.quickOrder.dao.AccountDaoImpl;
import com.ds.quickOrder.dao.CartDao;
import com.ds.quickOrder.dao.CategoryDao;
import com.ds.quickOrder.dao.SaleItemDao;
import com.ds.quickOrder.model.Account;
import com.ds.quickOrder.model.AccountEntity;
import com.ds.quickOrder.model.Category;
import com.ds.quickOrder.model.Company;
import com.ds.quickOrder.model.PastOrderItem;
import com.ds.quickOrder.model.SaleItem;
import com.ds.quickOrder.model.User;
import com.ds.quickOrder.repo.AccountRepo;
import com.ds.quickOrder.repo.CartItemRepo;
import com.ds.quickOrder.repo.CategoryRepo;
import com.ds.quickOrder.repo.CompanyRepo;
import com.ds.quickOrder.repo.PastOrderItemRepo;
import com.ds.quickOrder.repo.SaleItemRepo;
import com.ds.quickOrder.repo.UserRepo;

@SpringBootApplication
@ComponentScan(basePackages = "com.ds.quickOrder")
public class QuickOrderApplication implements CommandLineRunner {
	
	@Autowired
	private AccountRepo accountRepo;
	
	@Autowired
	private CartItemRepo cartRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private CompanyRepo companyRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private AccountDaoImpl accountDao;
	
	@Autowired 
	private PastOrderItemRepo pastRepo;
	
	@Autowired
	SaleItemRepo saleRepo;
	
	@Autowired
	SaleItemDao saleItemDao;
	
	
	
	@Autowired 
	CartDao cartDao;
	
	
	@Autowired
	CategoryDao categoryDao;
	
	public static void main(String[] args) {
		SpringApplication.run(QuickOrderApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application has started");
		System.out.println("Running Hibernate test");
		
//		Utils.printAllRepo(categoryRepo);
		
		//AccountDao testing
//		Account testAccount = accountDao.retrieveAccount("mjdilone");
//		System.out.println(testAccount.toString());
//		Account testAccountToAdd = new Account("Jason", "Albadeer", "albadeer@gmail.com", "alba", "albaPassword");
//		accountDao.addNewAccount(testAccountToAdd);
//		testAccount = accountDao.retrieveAccount(1003);
//		System.out.println(testAccount.toString());
		//past order item testing
//		Utils.printAllRepo(pastRepo);
//		Utils.printAll(accountDao.retrievePastOrders(1000));
		//user testing
//		accountDao.addNewUser(new User("Michaela","Dilly","userEntity@gmail",
//				"entityPassword","entityUsername"));
		
		
		
		
		
		//sale item testing
		System.out.println("sale item testing");
//		SaleItem item = saleItemDao.findSaleItemById(1004);
//		System.out.println(item.toString());
//		Utils.printAll(saleItemDao.getAllSaleItems());
//		Utils.printAll(saleRepo.searchWithName("spid"));
//		Utils.printAll(saleItemDao.searchSaleItemByName("spida"));
//		Utils.printAll(saleItemDao.searchSaleItemByCategory(new Category(1,"cartoon")));
		
		
		System.out.println("cart testing");
//		cartDao.addToCart(1005, 1001, 7);
//		cartDao.addToGuestCart(1005, Constants.testGuestUserId, 77);
//		Utils.printAll(cartRepo.findByUserId(1001));
//		Utils.printAll(cartRepo.findByGuestUserId(Constants.testGuestUserId));
		
//		cartRepo.copyCartToPastOrders(1001);
//		cartRepo.deleteWithCustomer_Id(1001);
//		cartRepo.copyGuestCartToPastOrders(505291976);
//		cartRepo.deleteWithGuest_Id(505291976);
		
		System.out.println("company testing");
//		Company testCompany = companyRepo.findByName(Constants.testCompanyName);
//		System.out.println(testCompany.toString());
		
		
		
		
		System.out.println("category testing");
//		Utils.printAll(categoryDao.getAllCategories());
//		Category testCategory = categoryDao.retrieveCategoryWithName("cartoon");
//		System.out.println(testCategory.toString());
		
		
		
		System.out.println("finished hibernate test");
	}
}