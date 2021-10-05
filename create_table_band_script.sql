CREATE TABLE album(album_id INTEGER,
					name VARCHAR,
					band_id INTEGER REFERENCES band(band_id),
					year SMALLINT);

CREATE TABLE band(band_id INTEGER NOT NULL PRIMARY KEY, 
					name VARCHAR (100),
					year SMALLINT,
					comment VARCHAR);
					
CREATE TABLE band_stats(band_id INTEGER REFERENCES band(band_id), 
					n_albums INTEGER,
					n_songs INTEGER);	
					
CREATE TABLE person(person_id INTEGER NOT NULL PRIMARY KEY,
					name VARCHAR (100),
					year SMALLINT);
					
CREATE TABLE band_person(band_id INTEGER REFERENCES band(band_id),
						person_id INTEGER REFERENCES person(person_id)); 								
