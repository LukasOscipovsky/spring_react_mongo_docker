import * as React from 'react';
import LoginPage from '../components/LoginPage';
import MuiThemeProvider from 'material-ui/styles/MuiThemeProvider';

class Login extends React.Component<any, any> {
    constructor(props: any) {
        super(props);
       }

public render() {
    return (
      <div>
        <MuiThemeProvider>
          <LoginPage/>
        </MuiThemeProvider>
      </div>
    );
  }
}

export default Login;