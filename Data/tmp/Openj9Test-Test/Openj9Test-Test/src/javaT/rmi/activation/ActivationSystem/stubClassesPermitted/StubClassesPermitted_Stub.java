package javaT.rmi.activation.ActivationSystem.stubClassesPermitted;
/*
 * Copyright (c) 1999, 2008, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

// Stub class generated by rmic, do not edit.
// Contents subject to change without notice.

public final class StubClassesPermitted_Stub
    extends java.rmi.server.RemoteStub
    implements CanCreateStubs, java.rmi.Remote
{
    private static final java.rmi.server.Operation[] operations = {
        new java.rmi.server.Operation("java.lang.Object getForbiddenClass()"),
        new java.rmi.server.Operation("java.rmi.registry.Registry getRegistry()"),
        new java.rmi.server.Operation("java.rmi.activation.ActivationGroupID returnGroupID()"),
        new java.rmi.server.Operation("void shutdown()")
    };

    private static final long interfaceHash = 1677779850431817575L;

    private static final long serialVersionUID = 2;

    private static boolean useNewInvoke;
    private static java.lang.reflect.Method $method_getForbiddenClass_0;
    private static java.lang.reflect.Method $method_getRegistry_1;
    private static java.lang.reflect.Method $method_returnGroupID_2;
    private static java.lang.reflect.Method $method_shutdown_3;

    static {
        try {
            java.rmi.server.RemoteRef.class.getMethod("invoke",
                new java.lang.Class[] {
                    java.rmi.Remote.class,
                    java.lang.reflect.Method.class,
                    java.lang.Object[].class,
                    long.class
                });
            useNewInvoke = true;
            $method_getForbiddenClass_0 = CanCreateStubs.class.getMethod("getForbiddenClass", new java.lang.Class[] {});
            $method_getRegistry_1 = CanCreateStubs.class.getMethod("getRegistry", new java.lang.Class[] {});
            $method_returnGroupID_2 = CanCreateStubs.class.getMethod("returnGroupID", new java.lang.Class[] {});
            $method_shutdown_3 = CanCreateStubs.class.getMethod("shutdown", new java.lang.Class[] {});
        } catch (java.lang.NoSuchMethodException e) {
            useNewInvoke = false;
        }
    }

    // constructors
    public StubClassesPermitted_Stub() {
        super();
    }
    public StubClassesPermitted_Stub(java.rmi.server.RemoteRef ref) {
        super(ref);
    }

    // methods from remote interfaces

    // implementation of getForbiddenClass()
    public java.lang.Object getForbiddenClass()
        throws java.lang.Exception
    {
        if (useNewInvoke) {
            Object $result = ref.invoke(this, $method_getForbiddenClass_0, null, -658265783646674294L);
            return ((java.lang.Object) $result);
        } else {
            java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 0, interfaceHash);
            ref.invoke(call);
            java.lang.Object $result;
            try {
                java.io.ObjectInput in = call.getInputStream();
                $result = (java.lang.Object) in.readObject();
            } catch (java.io.IOException e) {
                throw new java.rmi.UnmarshalException("error unmarshalling return", e);
            } catch (java.lang.ClassNotFoundException e) {
                throw new java.rmi.UnmarshalException("error unmarshalling return", e);
            } finally {
                ref.done(call);
            }
            return $result;
        }
    }

    // implementation of getRegistry()
    public java.rmi.registry.Registry getRegistry()
        throws java.rmi.RemoteException
    {
        try {
            if (useNewInvoke) {
                Object $result = ref.invoke(this, $method_getRegistry_1, null, 255311215504696981L);
                return ((java.rmi.registry.Registry) $result);
            } else {
                java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 1, interfaceHash);
                ref.invoke(call);
                java.rmi.registry.Registry $result;
                try {
                    java.io.ObjectInput in = call.getInputStream();
                    $result = (java.rmi.registry.Registry) in.readObject();
                } catch (java.io.IOException e) {
                    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
                } catch (java.lang.ClassNotFoundException e) {
                    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
                } finally {
                    ref.done(call);
                }
                return $result;
            }
        } catch (java.lang.RuntimeException e) {
            throw e;
        } catch (java.rmi.RemoteException e) {
            throw e;
        } catch (java.lang.Exception e) {
            throw new java.rmi.UnexpectedException("undeclared checked exception", e);
        }
    }

    // implementation of returnGroupID()
    public java.rmi.activation.ActivationGroupID returnGroupID()
        throws java.rmi.RemoteException
    {
        try {
            if (useNewInvoke) {
                Object $result = ref.invoke(this, $method_returnGroupID_2, null, 6267304638191237098L);
                return ((java.rmi.activation.ActivationGroupID) $result);
            } else {
                java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 2, interfaceHash);
                ref.invoke(call);
                java.rmi.activation.ActivationGroupID $result;
                try {
                    java.io.ObjectInput in = call.getInputStream();
                    $result = (java.rmi.activation.ActivationGroupID) in.readObject();
                } catch (java.io.IOException e) {
                    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
                } catch (java.lang.ClassNotFoundException e) {
                    throw new java.rmi.UnmarshalException("error unmarshalling return", e);
                } finally {
                    ref.done(call);
                }
                return $result;
            }
        } catch (java.lang.RuntimeException e) {
            throw e;
        } catch (java.rmi.RemoteException e) {
            throw e;
        } catch (java.lang.Exception e) {
            throw new java.rmi.UnexpectedException("undeclared checked exception", e);
        }
    }

    // implementation of shutdown()
    public void shutdown()
        throws java.lang.Exception
    {
        if (useNewInvoke) {
            ref.invoke(this, $method_shutdown_3, null, -7207851917985848402L);
        } else {
            java.rmi.server.RemoteCall call = ref.newCall((java.rmi.server.RemoteObject) this, operations, 3, interfaceHash);
            ref.invoke(call);
            ref.done(call);
        }
    }
}
