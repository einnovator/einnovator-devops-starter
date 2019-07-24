package org.einnovator.devops.client.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.einnovator.util.model.EntityBase;
import org.einnovator.util.model.ToStringCreator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Environment extends EntityBase {

	private Scope scope;

	protected List<Variable> vars;
	
	//
	// Constructors
	//
	
	/**
	 * Create instance of {@code Environment}.
	 *
	 */
	public Environment() {
	}

	public Environment(Environment env, boolean copyVars) {
		super(env);
		if (env!=null && copyVars && env.getVars()!=null) {
			this.vars = new ArrayList<>();
			for (Variable var: env.getVars()) {
				addVariable(new Variable(var));
			}			
		}
	}

	/**
	 * Create instance of {@code Environment}.
	 *
	 * @param env
	 */
	public Environment(Map<String, Object> env) {
		if (env!=null) {
			
		}
	}

	//
	// Getters and setters
	//


	/**
	 * Get the value of property {@code variables}.
	 *
	 * @return the variables
	 */
	public List<Variable> getVars() {
		return vars;
	}

	/**
	 * Set the value of property {@code variables}.
	 *
	 * @param variables the variables to set
	 */
	public void setVariables(List<Variable> vars) {
		this.vars = vars;
	}



	/**
	 * Get the value of property {@code scope}.
	 *
	 * @return the scope
	 */
	public Scope getScope() {
		return scope;
	}

	/**
	 * Set the value of property {@code scope}.
	 *
	 * @param scope the scope to set
	 */
	public void setScope(Scope scope) {
		this.scope = scope;
	}

	/**
	 * Set the value of property {@code vars}.
	 *
	 * @param vars the vars to set
	 */
	public void setVars(List<Variable> vars) {
		this.vars = vars;
	}
	
	
	public void addVariable(Variable var) {
		if (vars==null) {
			vars = new ArrayList<Variable>();
		}
		vars.add(var);
	}

	public Variable removeVariable(int index) {
		if (vars==null || index <0 || index>= vars.size()) {
			return null;
		}
		return vars.remove(index);
	}

	public Variable getVariable(int index) {
		if (vars==null || index <0 || index>= vars.size()) {
			return null;
		}
		return vars.get(index);
	}

	public Variable findVariable(Variable var) {
		if (var!=null && vars!=null) {
			for (Variable var2: vars) {
				if ((var2.getId()!=null && var2.getId().equals(var.getId())) || (var2.getName()!=null && var2.getName().equalsIgnoreCase(var.getName()))) {
					return var;
				}
			}
		}
		return null;
	}

	public Variable findVariable(String name) {
		if (name!=null && vars!=null) {
			for (Variable var: vars) {
				if (name.equalsIgnoreCase(var.getName())) {
					return var;
				}
			}
		}
		return null;
	}

	public Variable removeVariable(Variable var) {
		if (var!=null && vars!=null) {
			for (int i=0; i<vars.size(); i++) {
				Variable var2 = vars.get(i);
				if ((var2.getId()!=null && var2.getId().equals(var.getId())) || (var2.getName()!=null && var2.getName().equalsIgnoreCase(var.getName()))) {
					return vars.remove(i);
				}
			}
		}
		return null;
	}

	public Variable removeVariable(String name) {
		if (name!=null && vars!=null) {
			for (int i=0; i<vars.size(); i++) {
				Variable var = vars.get(i);
				if (name.equalsIgnoreCase(var.getName())) {
					return vars.remove(i);
				}
			}
		}
		return null;
	}

	

	@Override
	public ToStringCreator toString1(ToStringCreator creator) {
		return super.toString1(creator
				.append("scope", scope)
				.append("vars", vars)
				);
	}

	public String getValue(String name) {
		Variable var = findVariable(name);
		return var!=null ? var.getValue() : null;
	}

	public void setValue(String name, String value) {
		Variable var = findVariable(name);
		if (var==null) {
			addVariable(new Variable(name, value));
		} else {
			var.setValue(value);
		}
	}

	public String updateValue(String name, String value) {
		Variable var = findVariable(name);
		if (var==null) {
			return null;
		}
		var.setValue(value);
		return value;
	}

	public String getVarType(String name) {
		Variable var = findVariable(name);
		return var!=null ? var.getType() : null;
	}
	
	public Map<String, String> toMap() {
		Map<String, String> map = new LinkedHashMap<>();
		if (vars!=null) {
			for (Variable var: vars) {
				if (var!=null && var.getName()!=null) {
					map.put(var.getName(), var.getValue());
				}
			}
		}
		return map;
	}

}
