-- Include table data insertion, updation, deletion and select scripts
--    ----------------- A D M I N       F L O W-----------------------------------------

-- Adding MenuItems (Admin Table)

insert into menu_item
values
(1,  'Sandwich',  99.00,  'Yes',  '2017-03-15',  'Main Course',  'Yes'),
(2,  'Burger',  129.00,  'Yes',  '2017-12-23',  'Main Course',  'No'),
(3,  'Pizza',  149.00,  'Yes',' 2018-08-21', 'Main Course',  'No'),
(4,  'French Fries',  57.00,  'No', '2017-07-02', 'starters', 'Yes'),
(5,  'Chocolate Brownie',  32.00,  'Yes', '2022-11-02', 'dessert',  'Yes');

-- -----------------------------------------------------------------------------------
-- Show MenuItem list

select * from menu_item ;



-- -----------------------------------------------------------------------------------

-- Edit MenuItemList
update menu_item 
set me_name = 'Jamoon', me_price = 125.00 ,me_date_of_launch = '2018-05-02', me_free_delivery='Yes' where me_id=1; 

-- --------------------------------------------------------------------------------------
-- Edited MenuItem

select me_name, me_price, me_active, me_date_of_launch, me_category, me_free_delivery from menu_item where me_id = 1 ;

-- MenuItem List after edit 
select * from menu_item ;


-- -------------------------------------------------------------------------------------------
      
-- -----------------------  U S E R S    F L O W  --------------------------------------------


-- Add users to User Table
insert into user
values
(1,'Yogeesh'),
(2,'Ramesh'),
(3,'Girish');

select * from user  ;



-- -----------------------------------------------------------------------------------
 
-- Adding MenuItem (User Table)
select me_id, me_name, me_price, me_category from menu_item where me_active = 'Yes' and me_date_of_launch < current_date();


-- -----------------------------------------------------------------------------------
-- add to cart table
insert into cart 
values
(1,1,1),
(2,1,2),
(3,1,3),
(4,1,1),
(5,1,2),
(6,1,3);


-- -----------------------------------------------------------------------------------
-- Show Cart Items

select m.me_name, m.me_free_delivery , m.me_price  from menu_item m 
join cart c
on m.me_id = c.ct_pr_id  ;

-- -----------------------------------------------------------------------------------
-- delete cart item
delete from cart where ct_pr_id = 2 limit 1;



-- -----------------------------------------------------------------------------------
-- total price of cart items
select sum(m.me_price) as total from menu_item m 
join cart c
on m.me_id = c.ct_pr_id  ;
