CREATE TABLE facilities(
	facid INTEGER,
    name VARCHAR(100),
   membercost NUMERIC,
  guestcost NUMERIC,
  initialoutlay NUMERIC,
  monthlymaintanence NUMERIC,
  CONSTRAINT facilities_pk PRIMARY KEY (facid)
);
INSERT INTO facilities (facid,NAME,membercost,guestcost,initialoutlay,monthlymaintanence) VALUES (0,'Tennis Court 1',5,25,10000,200);
INSERT INTO facilities (facid,NAME,membercost,guestcost,initialoutlay,monthlymaintanence) VALUES (1,'Tennis Court 2',5,25,8000,200);
INSERT INTO facilities (facid,NAME,membercost,guestcost,initialoutlay,monthlymaintanence) VALUES (2,'Badminton Court',0,15.5,4000,50);
INSERT INTO facilities (facid,NAME,membercost,guestcost,initialoutlay,monthlymaintanence) VALUES (3,'Table Tennis',0,5,320,10);
INSERT INTO facilities (facid,NAME,membercost,guestcost,initialoutlay,monthlymaintanence) VALUES (4,'Massage Room 1',35,80,4000,3000);
INSERT INTO facilities (facid,NAME,membercost,guestcost,initialoutlay,monthlymaintanence) VALUES (5,'Massage Room 1',35,80,4000,3000);
INSERT INTO facilities (facid,NAME,membercost,guestcost,initialoutlay,monthlymaintanence) VALUES (6,'Squash Court',3.5,17.5,5000,80);
INSERT INTO facilities (facid,NAME,membercost,guestcost,initialoutlay,monthlymaintanence) VALUES (7,'Snooker Table',0,5,450,15);
INSERT INTO facilities (facid,NAME,membercost,guestcost,initialoutlay,monthlymaintanence) VALUES (8,'Pool Table',0,5,400,15);
CREATE TABLE members
    (
       memid integer NOT NULL, 
       surname character varying(200) NOT NULL, 
       firstname character varying(200) NOT NULL, 
       address character varying(300) NOT NULL, 
       zipcode integer NOT NULL, 
       telephone character varying(20) NOT NULL, 
       recommendedby integer,
       joindate timestamp NOT NULL,
       CONSTRAINT members_pk PRIMARY KEY (memid),
       CONSTRAINT fk_members_recommendedby FOREIGN KEY (recommendedby)
            REFERENCES members(memid) ON DELETE SET NULL
    );
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,joindate) VALUES (0,'GUEST','GUEST','GUEST',0,'(000) 000-0000','2012-07-01 00:00:00');
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,joindate) VALUES (1,'Smith','Darren','8 Bloomsbury close Boston',4321,'555-555-5555','2012-07-02 12:02:05');
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,joindate) VALUES (2,'Smith','Tracy','8 Bloomsbury close Boston',4321,'555-555-5555','2012-07-02 12:08:23');
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,joindate) VALUES (3,'Rownam','Tim','23 Highway Way, Boston',	23423,'(844) 693-0723','2012-07-03 09:32:15');
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,recommendedby,joindate) VALUES (4,'Joplette','Janice','20 Crossing Road, New York',234,'(833) 942-4710',1,'2012-07-03 10:25:05');
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,recommendedby,joindate) VALUES (5,'Butters','Gerald','1065 Huntingdon Avenue, Boston',56754,'(844) 078-4130',1,'2012-07-09 10:44:09');
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,joindate) VALUES (6,'Tracy','Burton','3 Tunisia Drive, Boston',45678,'(822) 354-9973','2012-07-15 08:52:55');
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,recommendedby,joindate) VALUES (7,'Dare','Nancy','6 Hunting Lodge Way, Boston',10383,'(833) 776-4001',4,'2012-07-25 08:59:12');
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,recommendedby,joindate) VALUES (8,'Boothe','Tim','3 Bloomsbury Close, Reading,00234',234,'(811) 433-2547',3,'2012-07-25 16:02:35');
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,recommendedby,joindate) VALUES (9,'Stibbons','Ponder','5 Dragons Way, Winchester',87630,'(833) 160-3900',6,'2012-07-25 17:09:05');
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,recommendedby,joindate) VALUES (10,'Owen','Charles','52 Cheshire Grove, Winchester, 28563',28563,'(855) 542-5251',1,'2012-08-03 19:42:37');
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,recommendedby,joindate) VALUES (11,'Jones','David','976 Gnats Close, Reading',33862,'(844) 536-8036',4,'2012-08-06 16:32:55');
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,recommendedby,joindate) VALUES (12,'Baker','Anne','55 Powdery Street, Boston',80743,'844-076-5141',9,'2012-08-10 14:23:22');
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,joindate) VALUES (13,'Farrell','Jemima','103 Firth Avenue, North Reading',57392,'(855) 016-0163','2012-08-10 14:28:01');
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,recommendedby,joindate) VALUES (14,'Smith','Jack','252 Binkington Way, Boston',69302,'(822) 163-3254',1,'2012-08-10 16:22:05');
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,recommendedby,joindate) VALUES (15,'Bader','Florence','264 Ursula Drive, Westford',84923,'(833) 499-352',9,'2012-08-10 17:52:03');
INSERT INTO members (memid,surname,firstname,address,zipcode,telephone,joindate) VALUES (16,'Smith','Darren','3 Funktown, Denzington, Boston',66796,'(822) 577-3541','2012-09-26 18:08:45');

CREATE TABLE bookings
    (
       bookid integer NOT NULL, 
       facid integer NOT NULL, 
       memid integer NOT NULL, 
       starttime timestamp NOT NULL,
       slots integer NOT NULL,
       CONSTRAINT bookings_pk PRIMARY KEY (bookid),
       CONSTRAINT fk_bookings_facid FOREIGN KEY (facid) REFERENCES facilities(facid),
       CONSTRAINT fk_bookings_memid FOREIGN KEY (memid) REFERENCES members(memid)
    );
INSERT INTO bookings (bookid,facid,memid,starttime,slots) VALUES (0,3,1,'2012-07-03 12:00:00',2);
INSERT INTO bookings (bookid,facid,memid,starttime,slots) VALUES (1,4,3,'2012-07-03 13:00:00',2);

select bks.starttime 
	from bookings bks
		inner join members mems
			on mems.memid = bks.memid
	where 
		mems.firstname='Tim'
		and mems.surname='Rownam';