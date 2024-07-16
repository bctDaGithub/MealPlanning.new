-- Execute this first
CREATE DATABASE MealPlanningDB;

-- Execute this next
USE MealPlanningDB;

-------------------------------------------------------------------
-- Users table
CREATE TABLE Users (
    UserId INT PRIMARY KEY IDENTITY(1,1),
    UserName NVARCHAR(50) NOT NULL,
    FullName NVARCHAR(50) NOT NULL,
    Password NVARCHAR(50) NOT NULL,
    RoleID INT NOT NULL,
    Email NVARCHAR(100) NOT NULL,
    Birthday DATE NOT NULL,
    Address NVARCHAR(255),
    Phone NVARCHAR(15) NOT NULL,
    status BIT NOT NULL,
);


------------------------------------------------------------------
-- Dishes table
CREATE TABLE Dishes (
    id INT IDENTITY PRIMARY KEY,
    name VARCHAR(255),
    description TEXT,
    calories INT,
    estimatedPrice INT,
    ingredients TEXT,
    method TEXT,
    imagePath VARCHAR(255)
);

-- Menu table
CREATE TABLE Menu (
    menuId INT PRIMARY KEY IDENTITY,
    name NVARCHAR(100) NOT NULL,
    description NVARCHAR(MAX),
    weekNumber INT NOT NULL,
    userId INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

-- Linking table between Menu and Dishes
CREATE TABLE MenuDishes (
    menuId INT NOT NULL,
    dishId INT NOT NULL,
    PRIMARY KEY (menuId, dishId),
    FOREIGN KEY (menuId) REFERENCES Menu(menuId),
    FOREIGN KEY (dishId) REFERENCES Dishes(id)
);

-- Orders table
CREATE TABLE Orders (
    orderId INT PRIMARY KEY IDENTITY,
    orderDate DATETIME NOT NULL,
    status NVARCHAR(50),
    total DECIMAL(10, 2),
    userId INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES Users(userId)
);

-- OrderDetails table
CREATE TABLE OrderDetails (
    detailId INT PRIMARY KEY IDENTITY,
    dishId INT NOT NULL,
    orderId INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY (dishId) REFERENCES Dishes(id),
    FOREIGN KEY (orderId) REFERENCES Orders(orderId)
);

-- MealPlans table
CREATE TABLE MealPlans (
    mealPlanId INT PRIMARY KEY IDENTITY,
    userId INT NOT NULL,
    weekStarting DATE NOT NULL,
    mealTime NVARCHAR(50) NOT NULL,
    dayOfWeek NVARCHAR(50) NOT NULL,
    dishId INT NOT NULL,
    FOREIGN KEY (userId) REFERENCES Users(userId),
    FOREIGN KEY (dishId) REFERENCES Dishes(id)
);

-- Thêm dữ liệu vào bảng Dishes
INSERT INTO Dishes (name, description, calories, estimatedPrice, ingredients, method, imagePath)
VALUES
    ('Grilled Chicken Salad', 'Grilled chicken, fresh greens, cherry tomatoes, and vinaigrette.', 300, 100000, '200g chicken, 200g fresh greens, 100g cherry tomatoes, 3 tablespoons vinaigrette.', 'Grill chicken, mix with greens and vinaigrette.', 'imageDishs/image1.jpg'),
    ('Quinoa and Black Bean Bowl (Vegan)', 'Quinoa, black beans, corn, avocado, and lime dressing.', 350, 80000, '100g quinoa, 200g black beans, 100g corn, 1 avocado, lime juice.', 'Cook quinoa, mix with beans, corn, avocado, and lime juice.', 'imageDishs/image2.jpg'),
    ('Baked Salmon with Asparagus', 'Oven-baked salmon with roasted asparagus and quinoa.', 400, 200000, '200g salmon, 200g asparagus, 100g quinoa.', 'Bake salmon and asparagus, serve with quinoa.', 'imageDishs/image3.jpg'),
    ('Vegetable Stir-Fry (Vegetarian)', 'Stir-fried vegetables with tofu over brown rice.', 250, 70000, '200g vegetables, 100g tofu, 100g brown rice.', 'Stir-fry vegetables and tofu, serve with brown rice.', 'imageDishs/image4.jpg'),
    ('Turkey and Avocado Wrap', 'Whole grain wrap with turkey, avocado, spinach, and hummus.', 400, 90000, '100g turkey, 1 avocado, 50g spinach, 2 tablespoons hummus, wrap.', 'Wrap all ingredients in the wrap.', 'imageDishs/image5.jpg'),
    ('Greek Yogurt with Berries and Nuts', 'Greek yogurt with fresh berries and nuts.', 200, 50000, '200g Greek yogurt, 100g strawberries, 50g nuts.', 'Mix yogurt with strawberries and nuts.', 'imageDishs/image6.jpg'),
    ('Steak and Sweet Potato', 'Grilled steak with roasted sweet potatoes and salad.', 450, 150000, '200g steak, 200g sweet potatoes, 200g greens.', 'Grill steak and sweet potatoes, serve with greens.', 'imageDishs/image7.jpg'),
    ('Chickpea and Spinach Curry (Vegan)', 'Chickpea and spinach curry with brown rice.', 350, 70000, '200g chickpeas, 100g spinach, 200ml coconut milk, 100g brown rice.', 'Cook chickpea and spinach curry, serve with brown rice.', 'imageDishs/image8.jpg'),
    ('Grilled Shrimp Skewers', 'Grilled shrimp with quinoa salad.', 300, 150000, '200g shrimp, 100g quinoa, greens.', 'Skewer and grill shrimp, serve with quinoa salad.', 'imageDishs/image9.jpg'),
    ('Eggplant Parmesan (Vegetarian)', 'Baked eggplant with marinara and cheese, served with pasta.', 350, 80000, '2 eggplants, marinara sauce, 100g cheese, 200g pasta.', 'Bake eggplant with marinara and cheese, serve with pasta.', 'imageDishs/image10.jpg'),
    ('Chicken and Veggie Skewers', 'Chicken and vegetable skewers with couscous.', 350, 100000, '200g chicken, 200g vegetables, 100g couscous.', 'Skewer and grill chicken and vegetables, serve with couscous.', 'imageDishs/image11.jpg'),
    ('Protein Smoothie', 'Smoothie with protein powder, almond milk, banana, and spinach.', 250, 50000, '1 scoop protein powder, 200ml almond milk, 1 banana, 50g spinach.', 'Blend all ingredients.', 'imageDishs/image12.jpg'),
    ('Zucchini Noodles with Pesto (Vegetarian)', 'Zucchini noodles with pesto and cherry tomatoes.', 200, 70000, '2 zucchinis, pesto sauce, 100g cherry tomatoes.', 'Make noodles from zucchini, mix with pesto and cherry tomatoes.', 'imageDishs/image13.jpg'),
    ('Stuffed Bell Peppers (Vegan)', 'Bell peppers stuffed with quinoa, beans, and vegetables.', 300, 60000, '4 bell peppers, 100g quinoa, 100g beans, vegetables.', 'Stuff bell peppers with quinoa and beans, bake.', 'imageDishs/image14.jpg'),
    ('Grilled Chicken with Cauliflower Rice', 'Grilled chicken with cauliflower rice.', 300, 90000, '200g chicken, 1 cauliflower.', 'Grill chicken, process cauliflower into "rice", cook.', 'imageDishs/image15.jpg'),
    ('Greek Salad with Tofu (Vegetarian)', 'Greek salad with tofu cubes.', 250, 60000, '200g greens, 100g tofu, 100g tomatoes, 50g feta cheese, olive oil.', 'Mix all ingredients.', 'imageDishs/image16.jpg'),
    ('Beef Lettuce Wraps', 'Ground beef with vegetables in lettuce leaves.', 250, 80000, '200g ground beef, 200g vegetables, 10 lettuce leaves.', 'Stir-fry beef and vegetables, wrap in lettuce leaves.', 'imageDishs/image17.jpg'),
    ('Avocado and Egg Breakfast', 'Baked egg in avocado halves.', 200, 40000, '2 avocados, 2 eggs.', 'Remove avocado pit, crack egg into avocado, bake.', 'imageDishs/image18.jpg'),
    ('Salmon and Quinoa Salad', 'Grilled salmon with quinoa and greens.', 400, 150000, '200g salmon, 100g quinoa, greens.', 'Grill salmon, mix with quinoa and greens.', 'imageDishs/image19.jpg'),
    ('Lentil Soup (Vegan)', 'Lentil soup with carrots, celery, and spinach.', 250, 50000, '200g lentils, 2 carrots, 2 celery stalks, 100g spinach.', 'Cook lentils with carrots, celery, and spinach.', 'imageDishs/image20.jpg'),
    ('Chicken and Broccoli Stir-Fry', 'Stir-fried chicken with broccoli in soy sauce.', 300, 80000, '200g chicken, 200g broccoli, 2 tablespoons soy sauce.', 'Stir-fry chicken with broccoli and soy sauce.', 'imageDishs/image21.jpg'),
    ('Vegetarian Chili', 'Chili with beans, tomatoes, and spices.', 250, 70000, '200g mixed beans, 2 tomatoes, spices.', 'Cook beans with tomatoes and spices.', 'imageDishs/image22.jpg'),
    ('Tuna and Avocado Salad', 'Tuna mixed with avocado and red onion.', 300, 90000, '1 can tuna, 1 avocado, 1 red onion.', 'Mix tuna, avocado, and red onion.', 'imageDishs/image23.jpg'),
    ('Oatmeal with Fresh Fruit', 'Oatmeal with berries, banana, and honey.', 200, 40000, '50g oats, 100g strawberries, 1 banana, 1 tablespoon honey.', 'Cook oats, add strawberries, banana, and honey.', 'imageDishs/image24.jpg'),
    ('Spaghetti Bolognese', 'Whole grain spaghetti with meat sauce.', 450, 100000, '200g whole grain spaghetti, 200g ground beef, 2 tomatoes, spices.', 'Cook ground beef with tomatoes and spices, serve with spaghetti.', 'imageDishs/image25.jpg'),
    ('Vegetarian Pizza', 'Whole wheat crust pizza with vegetables and cheese.', 400, 80000, 'Whole wheat pizza crust, 200g vegetables, 100g cheese.', 'Bake pizza crust with vegetables and cheese.', 'imageDishs/image26.jpg'),
    ('Chicken Pot Pie', 'Chicken pot pie with a flaky crust.', 450, 120000, '200g chicken, 200g vegetables, 1 pie crust.', 'Cook chicken with vegetables, place in pie crust, bake.', 'imageDishs/image27.jpg'),
    ('Vegetable Lasagna (Vegetarian)', 'Lasagna with vegetables, ricotta, and marinara.', 350, 90000, '200g lasagna, 200g vegetables, 100g ricotta, marinara sauce.', 'Layer lasagna with vegetables, ricotta, and marinara sauce, bake.', 'imageDishs/image28.jpg'),
    ('Beef Stew', 'Slow-cooked beef stew with potatoes, carrots, and peas.', 400, 100000, '200g beef, 200g potatoes, 2 carrots, 100g peas.', 'Slow-cook beef with potatoes, carrots, and peas.', 'imageDishs/image29.jpg'),
    ('Vegan Chocolate Mousse', 'Chocolate mousse made with avocado and cocoa.', 200, 50000, '2 avocados, 2 tablespoons cocoa powder, 1 tablespoon honey.', 'Blend avocados, cocoa powder, and honey.', 'imageDishs/image30.jpg');