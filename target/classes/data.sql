
insert into tour_package (code, name) values
                                          ('BC', 'Backpack Cal'),
                                          ('CC', 'California Calm'),
                                          ('CH', 'California Hot springs'),
                                          ('CY', 'Cycle California'),
                                          ('DS', 'From Desert to Sea'),
                                          ('KC', 'Kids California'),
                                          ('NW', 'Nature Watch'),
                                          ('SC', 'Snowboard Cali'),
                                          ('TC', 'Taste of California');
INSERT INTO tour (tour_package_code, title, description, blurb, bullets, price, duration, difficulty, region, keywords)
VALUES
    ('BC', 'Beach Vacation', 'Relax and unwind on beautiful coastal beaches.', 'Escape to a peaceful beach paradise.', 'Enjoy sandy shores and refreshing ocean views.', 900, '7 days', 'Easy', 'Southern California', 'beach, relaxation, sea'),
    ('CC', 'Wine Country Tour', 'Explore the scenic vineyards and taste exquisite wines.', 'Indulge in the flavors of the renowned wine country.', 'Visit charming wineries and enjoy the picturesque landscapes.', 1200, '8 days', 'Medium', 'Northern California', 'wine, vineyards, tour'),
    ('CH', 'Mountain Chalet Retreat', 'Experience the coziness of a mountain chalet.', 'Escape to a charming retreat nestled in the mountains.', 'Enjoy breathtaking views and serene surroundings.', 1100, '6 days', 'Difficult', 'Central Coast', 'mountain, chalet, retreat'),
    ('CY', 'City Lights Tour', 'Immerse yourself in the vibrant city lights and nightlife.', 'Experience the excitement of urban exploration at night.', 'Visit iconic landmarks illuminated in the cityscape.', 800, '5 days', 'Medium', 'Varies', 'city, nightlife, exploration');
insert into tour_rating (tour_id, customer_id, score, comment) values
(1, 4, 5, 'I loved it'),
(2, 100, 5, 'I really thought it could have been better');