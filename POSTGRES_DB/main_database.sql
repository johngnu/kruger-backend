CREATE TABLE security."user"
(
  id integer NOT NULL,
  enabled boolean NOT NULL,
  username character varying(100) NOT NULL,
  password character varying(100) NOT NULL,
  created_by character varying(50),
  created_date timestamp without time zone,
  updated_by character varying(50),
  updated_date timestamp without time zone,
  CONSTRAINT user_pkey PRIMARY KEY (id),
  CONSTRAINT user_username_key UNIQUE (username)
);

CREATE TABLE kruger.vaccine
(
  id serial NOT NULL,  
  name character varying(100) NOT NULL,  
  created_by character varying(50),
  created_date timestamp without time zone,
  updated_by character varying(50),
  updated_date timestamp without time zone,  
  CONSTRAINT vacuna_pkey PRIMARY KEY (id)
);

CREATE TABLE kruger.employee
(
  id serial NOT NULL,
  cedula character varying(10) NOT NULL,
  nombres character varying(100) NOT NULL,
  apellidos character varying(100) NOT NULL,
  email character varying(100) NOT NULL,
  birthday date,
  address character varying(256),
  movil integer,
  vacunado boolean,
  vaccine integer,
  nro_dosis integer, 
  vaccine_date date,
  "user" integer,
  created_by character varying(50),
  created_date timestamp without time zone,
  updated_by character varying(50),
  updated_date timestamp without time zone,  
  CONSTRAINT employee_pkey PRIMARY KEY (id),
  CONSTRAINT employee_user_fkey FOREIGN KEY ("user") REFERENCES security.user (id),
  CONSTRAINT vaccine_fkey FOREIGN KEY (vaccine) REFERENCES kruger.vaccine (id),
  CONSTRAINT employee_cedula_key UNIQUE (cedula)
);

CREATE TABLE security.role
(
  id serial NOT NULL,
  name character varying(50),
  enabled boolean,
  CONSTRAINT role_pkey PRIMARY KEY (id)
);

CREATE TABLE security.user_role
(
  id serial NOT NULL,
  "user" integer,
  role integer,
  CONSTRAINT user_role_pkey PRIMARY KEY (id),
  CONSTRAINT user_role_role_fkey FOREIGN KEY (role) REFERENCES security.role (id),      
  CONSTRAINT user_role_user_fkey FOREIGN KEY ("user") REFERENCES security."user" (id)
)