import * as React from 'react';
import * as ReactDOM from 'react-dom';
import Login from './views/Login';
import registerServiceWorker from './registerServiceWorker';

import './styles/App.scss';

ReactDOM.render(
  <Login />,
  document.getElementById('root') as HTMLElement
);
registerServiceWorker();
