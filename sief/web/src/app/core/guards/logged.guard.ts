import { CanActivateFn } from '@angular/router';

export const loggedGuard: CanActivateFn = (route, state) => {
  //sessionStorage.setItem('acceso', 'true');
  //return sessionStorage.getItem('grant') == 'admin';
  return true;
};
