DROP DATABASE IF EXISTS mystore_db;
CREATE DATABASE mystore_db;

USE mystore_db;

DROP TABLE UserAccount;
CREATE TABLE IF NOT EXISTS UserAccount
(UserID INT NOT NULL AUTO_INCREMENT,
UserEmail VARCHAR(30) NOT NULL UNIQUE,
UserName VARCHAR(20) NOT NULL,
UserPassword VARCHAR(20) NOT NULL,
UserRole INT NOT NULL,
PRIMARY KEY (UserID)
);

DROP TABLE Product;
CREATE TABLE IF NOT EXISTS Product
(ProductID INT NOT NULL AUTO_INCREMENT,
ProductSKU VARCHAR(20) UNIQUE,
ProductName VARCHAR(100) NOT NULL,
ProductPrice FLOAT(50) NOT NULL,
ProductStock INT NOT NULL,
ProductManufacturer VARCHAR(50) NULL,
ProductCategory VARCHAR(30) NOT NULL,
ProductCondition INT NOT NULL,
ProductDescription TEXT NOT NULL,
ProductSrc VARCHAR(100) NULL,
PRIMARY KEY (ProductID)
);


INSERT INTO UserAccount(UserName, UserEmail, UserPassword, UserRole)
VALUES
('ROOT', 'root@example.com', 'root', 1102),
('USER', 'user@example.com', 'user', 1101);

INSERT INTO Product(ProductSKU, ProductName, ProductPrice, ProductStock, ProductManufacturer, ProductCategory, ProductCondition, ProductDescription, ProductSrc)
VALUES
('PPHONE-MB1', 'PINEPHONE – “Community Edition: Mobian” Limited Edition Linux SmartPhone', 149.99, 10, 'PINE Store', 'Linux', 1, 'This is the Community Edition of the PinePhone, featuring Mobian. This limited edition PinePhone is aimed primary at Mobian community members. The core purpose of this campaign is to provide hardware capable of running mainline Linux to members of this community, so the Mobian developers can benefit from feedback and code contributions to their project.', 'PPHONE-MB1.png'),
('PPHONE-MB2', 'PINEPHONE – “Community Edition: Mobian With Convergence Package” Limited Edition Linux SmartPhone', 199.99, 5, 'PINE Store', 'Linux', 1, 'This is the Community Edition of the PinePhone featuring Mobian. This limited edition PinePhone is aimed primary at Mobian community members. The core purpose of this campaign is to provide hardware capable of running mainline Linux to members of this community, so the Mobian developers can benefit from feedback and code contributions to their project.', 'PPHONE-MB2.png'),
('IPHONE11-P', 'iPhone 11', 499.99, 50, 'Apple', 'iOS', 1, 'The iPhone 11 boasts the new Apple A13 Bionic chip - the same SoC that powers the flagship iPhone 11 Pro duo. It also gets a second camera, and it\'s the new 12MP ultra wide-angle snapper, also brought from the Pro models. Features like Crop Out of Frame are available as well, and also shooting 4K videos with all cameras at once.', 'IPHONE11-P.png'),
('IPHONEXR-B', 'iPhone XR', 529.99, 5, 'Apple', 'iOS', 1, 'What you still get is the same general iPhone X series design, the same powerful A12 Bionic chipset from the XS, the same TrueDepth camera with the faster Face ID system and the single camera on the back is the same as the main 12MP sensor on the back of the XS.', 'IPHONEXR-B.png'),
('SAMSUNGZ-FOLD2', 'Samsung Galaxy Z Fold2', 2899.0, 20, 'Samsung', 'Android', 1, 'The Z Fold2 is more than anything an embodiment of technological, product, and design maturity. The Z Fold2 is a more polished iteration of the form factor in every conceivable way.', 'SAMSUNGZ-FOLD2.png'),
('SAMSUNGS-US21', 'Samsung Galaxy S21 Ultra', 1299.0, 20, 'Samsung', 'Android', 1, 'The Galaxy S21 Ultra is the only S21 model to come with a 1440p OLED screen, unlike the previous generation. And even better, it now supports 120Hz at that high resolution, so you don\'t need to choose between high res and high refresh rate. This new Ultra screen also supports Adaptive Refresh Rate that can vary between 10Hz and 120Hz, just like the Note20 Ultra.', 'SAMSUNGS-US21.png'),
('SAMSUNGN-UN20', 'Samsung Note 20 Ultra', 1299.99, 30, 'Samsung', 'Android', 1, 'First appearing on the other S20 Ultra, the oversized camera hump makes a return on the Note20 Ultra. Most of the bits inside are the same, including the main 108MP cam and the 12MP ultra wide. But the periscope telephoto that\'s in part responsible for the sheer size of the assembly is now 12MP, swapping out the 48MP unit of the S-series phone - we\'ll have to see about that.', 'SAMSUNGN-UN20.png'),
('GOOGLE-PIXEL5', 'Google Pixel 5', 679.99, 35, 'Google', 'Android', 1, 'The overall form factor is far more manageable with a 6-inch display with a punch-hole selfie camera cut out and compact size. The Pixel 5\'s design is largely based on the Pixel 4a that came just weeks before it, but it comes with the slimmest bezels we\'ve ever seen on a Pixel phone. It also has a beefier 4080mAh battery compared to the Pixel 4 XL\'s 3,800 mAh. Combined with the power-efficient Snapdragon 765G, the Pixel 5 should also see improvements in battery life, but we\'ll get to that.', 'GOOGLE-PIXEL5.png'),
('GOOGLE-PIXEL4A', 'Google Pixel 4a', 459.0, 15, 'Google', 'Android', 1, 'There\'s the new Pixel 4a 5G, which we chose instead of Pixel 5 for having the same camera but on a cheaper price. Some time ago the Pixels were a straight-up recommendation when it comes to taking photos on the phone, but that\'s no more.', 'GOOGLE-PIXEL4A.png');


