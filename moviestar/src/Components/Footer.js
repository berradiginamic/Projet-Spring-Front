import React from "react";
import { NavLink } from "react-router-dom";

const Footer = () => {
  const data = [
    {
          icon: "fas fa-home",
          name: "Home",
          link: "/",
        },
        {
              icon: "fas fa-search",
              name: "Recherche",
              link: "/recherche",
            },
    {
      icon: "fas fa-fire-alt",
      name: "Acteurs",
      link: "/acteurs",
    },
    {
      icon: "fas fa-film",
      name: "Films",
      link: "/films",
    },
    {
      icon: "fas fa-tv",
      name: "Genres",
      link: "/genres",
    },
    {
      icon: "fas fa-search",
      name: "Réalisateurs",
      link: "/realisateurs",
    },
  ];
  return (
    <div className="container-fluid">
      <div className="row">
        <div className="col-12 text-center bg-dark footer">
          {data.map((Val, index) => (
            <NavLink key={index} to={Val.link}>
              <button className="col-sm-2 col-md-2 btn btn-dark">
                <i className={`${Val.icon}`} id="fire"></i>
                <br />
                <h5 className="pt-1 fs-6">{Val.name}</h5>
              </button>
            </NavLink>
          ))}
        </div>
      </div>
    </div>
  );
};

export default Footer;