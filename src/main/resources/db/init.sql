-- Create the database
IF NOT EXISTS (SELECT * FROM sys.databases WHERE name = 'CourseRegistration')
BEGIN
    CREATE DATABASE CourseRegistration;
END

-- Use the database
USE CourseRegistration;
GO

-- Create course_requests table
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[course_requests]') AND type in (N'U'))
BEGIN
    CREATE TABLE course_requests (
        id BIGINT IDENTITY(1,1) PRIMARY KEY,
        date DATE NOT NULL,
        student_first_name NVARCHAR(100) NOT NULL,
        student_last_name NVARCHAR(100) NOT NULL,
        student_id NVARCHAR(10) NOT NULL,
        student_year INT NOT NULL,
        study_field NVARCHAR(100) NOT NULL,
        advisor NVARCHAR(100) NOT NULL,
        address_number NVARCHAR(50) NOT NULL,
        moo NVARCHAR(10) NOT NULL,
        tumbol NVARCHAR(100) NOT NULL,
        amphur NVARCHAR(100) NOT NULL,
        province NVARCHAR(100) NOT NULL,
        postal_code NVARCHAR(10) NOT NULL,
        mobile_phone NVARCHAR(10) NOT NULL,
        phone NVARCHAR(10),
        cause NVARCHAR(500) NOT NULL
    );
END

-- Create subjects table
IF NOT EXISTS (SELECT * FROM sys.objects WHERE object_id = OBJECT_ID(N'[dbo].[subjects]') AND type in (N'U'))
BEGIN
    CREATE TABLE subjects (
        id BIGINT IDENTITY(1,1) PRIMARY KEY,
        course_request_id BIGINT NOT NULL,
        subject_code NVARCHAR(10) NOT NULL,
        subject_name NVARCHAR(100) NOT NULL,
        subject_section NVARCHAR(10) NOT NULL,
        subject_date NVARCHAR(50) NOT NULL,
        subject_credit NVARCHAR(2) NOT NULL,
        subject_teacher NVARCHAR(100) NOT NULL,
        subject_teacher_check BIT NOT NULL DEFAULT 0,
        FOREIGN KEY (course_request_id) REFERENCES course_requests(id) ON DELETE CASCADE
    );
END 