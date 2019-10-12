# SinghNicerShop
Assignment 2 for graphical and wireless.
The emulator I would like you to use is Nexus 5X.
From my end, the code works fine. The only bug in my code is that mybackground colour for my menu didnt change, but i prefer the all white.
It makes it so that the product is the main focus.

This project revoles around a shopping application. It includes a main page, a menu page and a chekout page, a dropdown menu page,. 
The main page includes a title
(the name of my application), a description of the application (what it does) and a button that directs you to the menu page.

The menu page icludes only a RecyclerView. 

The checkout page includes 4 label text vie for thesubtotal,shipping, GST, QST and a final price. It includes the value of those labels,
a title saying "Checkout" and a thank you message. 

For the classe, I have a MainActivity, MenuActivity, CheckoutActivity, ShoppingItems and a ProductAdapter class.

In the Main, I just call the MENU.

iN THE MENU, I have one of the bulk of my assignment. I have a alertSection for the dropdown menu with the use of toast. Ihave an array to get the ressorces for the Element in the xml. I have a loop to add the elements to a linked list by calling the ShoppingItem class. Then, I handle the RECYCLER. tHEN I procced to checkout.
I have a section for the rotation. 

The shoppingItems is the squeleton of my layout.It host all the layout element and getters setters.

The productAdapter is a complicated class. The adapter calss has the onBind, oncreate and the getitemcount methods. That class has a inner calss(new for me).This is where my buttons are registered.

In the checkout class, I do my calculations and display the information.

I used somepictures from the internet for the products that I'm is displaying. 
Those pictures are:
https://www.karizmajewels.com/sikh-khanda-pendant-chain-necklace-steel-sihism-symbol-punjabi-jewelry-18-inches
https://www.sikhkaras.com/custom/
https://www.khalsakirpans.com/pages/artisan-kirpan
https://www.amazon.com/Punjabi-Salaee-Needle-Turban-Kirpaan/dp/B06XBQFT55
https://sikhaccessories.com/fifty/
https://www.amazon.com/Mustache-Wax-Mountaineer-Brand-All-Natural/dp/B00I1OO2JC
https://sarblohstore.com/product/kanga-wooden-comb
https://www.muteyaar.com/blue-sikh-bana-chola-for-nihang-singh-all-sizes-available-custom-stitching/
https://www.exportersindia.com/singh-suppliers-company5948287/gatra-4400783.htm
https://www.amazon.in/Unique-Mens-Punjabi-Juti-Black/dp/B01N8XEBD2



I was told to think up some menu ideas. According to my research. You have popup, contextual. The menu type is usually on the top. I is used for searching or editing the applications. I think i will use this fto display the address of the warehouses for each cities. A contextual Menu is used when you long press an item. I might use it too specify the size for some of myproduct.


