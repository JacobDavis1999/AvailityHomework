import React from 'react'
import Client from './Client';


//For each element in clientData/database, pass that down as a prop to Client component 
  const Clients = ({clientData, deleteClient}) => {
      return(
          <div>
              {clientData.map((t) => {
                  return(
                   <Client key={t.id} client = {t} deleteClient={deleteClient} />
                  )
                  
              })}
          </div>
      );
  }

  export default Clients