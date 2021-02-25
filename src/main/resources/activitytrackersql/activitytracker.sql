CREATE SCHEMA if NOT EXISTS activitytracker DEFAULT CHARACTER SET UTF8 COLLATE UTF8_HUNGARIAN_CI;

CREATE USER 'activitytracker' IDENTIFIED BY 'activitytracker';

GRANT ALL ON *.* TO 'activitytracker';