CREATE TABLE facilities(
	facid INTEGER,
    name VARCHAR(100),
   membercost NUMERIC,
  guestcost NUMERIC,
  initialoutlay NUMERIC,
  monthlymaintanence NUMERIC
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
select * from cd.facilities where facid in (1,5);